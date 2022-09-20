package unlam.progava.oia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlgoritmoKruskal {

	private ArrayList<Arista> aristas = new ArrayList<>();
	private ArrayList<Arista> MST = new ArrayList<>();
	private int ciudadesConCentrales[];
	private int padres[];
	private int tam;
	private int costoTotal;

	public AlgoritmoKruskal(int MA[][], int tam, int ciudadesConCentrales[]) {
		// TODO Auto-generated constructor stub
		padres = new int[tam];
		this.tam = tam;

		for (int i = 0; i < tam - 1; i++) {
			for (int j = 1 + i; j < tam; j++) {
				aristas.add(new Arista(i, j, MA[i][j]));
			}
		}

		this.ciudadesConCentrales = ciudadesConCentrales;

		Collections.sort(aristas, new Comparator<Arista>() {
			@Override
			public int compare(Arista o1, Arista o2) {
				// TODO Auto-generated method stub
				return o1.peso - o2.peso;
			}
		});
	}

	public void KruskalMST() {
		int origen, destino, peso;
		int total = 0;

		MakeSet(tam);

		for (int i = 0; i < aristas.size(); ++i) {
			origen = aristas.get(i).origen;
			destino = aristas.get(i).destino;
			peso = aristas.get(i).peso;

			if (!sameComponent(origen, destino) && !ambosTienenCentrales(origen, destino)) {
				total += peso;
				MST.add(new Arista(aristas.get(i).origen + 1, aristas.get(i).destino + 1, aristas.get(i).peso));
				Union(origen, destino);
			}
		}
		costoTotal = total;
	}

	/// UNION-FIND

	private void MakeSet(int n) {
		for (int i = 1; i < n; ++i)
			padres[i] = i;
	}

	private int Find(int x) {
		return (x == padres[x]) ? x : (Find(padres[x]));
	}

	private void Union(int x, int y) {

		boolean origen = false;

		int aux = Find(x);
		for (int ciudad : ciudadesConCentrales) {
			if (aux == ciudad - 1)
				origen = true;
		}

		if (origen)
			padres[Find(y)] = Find(x);
		else
			padres[Find(x)] = Find(y);
	}
	private boolean sameComponent(int x, int y) {
		if (Find(x) == Find(y))
			return true;
		return false;
	}

	private boolean ambosTienenCentrales(int x, int y) {
		boolean origen = false;
		boolean destino = false;

		int aux = Find(x);
		for (int ciudad : ciudadesConCentrales) {
			if (aux == ciudad - 1)
				origen = true;
		}

		aux = Find(y);
		for (int ciudad : ciudadesConCentrales) {
			if (aux == ciudad - 1)
				destino = true;
		}

		if (origen && destino)
			return true;

		return false;
	}

	/// FIN UNION-FIND

	public int getCostoTotal() {
		return costoTotal;
	}

	public ArrayList<Arista> getMST() {
		return MST;
	}

}
