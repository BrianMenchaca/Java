package metro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlgoritmoKruskal {

	private ArrayList<Camino> lista = new ArrayList<>();
	private ArrayList<Camino> MST = new ArrayList<>();
	private int padres[];
	private int tam;
	private int maxTunelesYPuentes = 12000;
	private int costoTotal;

	public AlgoritmoKruskal(int MA[][], int tam) {
		// TODO Auto-generated constructor stub
		padres = new int[tam + 1];
		this.tam = tam;
		for (int i = 0; i < tam - 1; i++) {
			for (int j = 1 + i; j < tam; j++) {
				if (MA[i][j] != -1)
					lista.add(new Camino(i + 1, j + 1, MA[i][j]));
			}
		}

		Collections.sort(lista, new Comparator<Camino>() {
			@Override
			public int compare(Camino o1, Camino o2) {
				// TODO Auto-generated method stub
				return o1.peso - o2.peso;
			}
		});
		
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).origen + " " + lista.get(i).destino +" " + lista.get(i).peso);
		}
		
		System.out.println(" ");
	}

	public void KruskalMST() {
		int origen, destino, peso;
		int total = 0; // Peso total del MST
		int numAristas = 0; // Numero de Aristas del MST

		MakeSet(tam); // Inicializamos cada componente

		for (int i = 0; i < lista.size(); ++i) { // Recorremos las aristas ya ordenadas por peso
			origen = lista.get(i).origen; // Vértice origen de la arista actual
			destino = lista.get(i).destino; // Vértice destino de la arista actual
			peso = lista.get(i).peso; // Peso de la arista actual

			// Verificamos si estan o no en la misma componente conexa
			if (!sameComponent(origen, destino)) { // Evito ciclos
				total += peso; // Incremento el peso total del MST
				MST.add(lista.get(i)); // Agrego al MST la arista actual
				numAristas++;
				Union(origen, destino); // Union de ambas componentes en una sola
			}
		}
		
		for(int i = 0; i < MST.size(); i++) {
			System.out.println(MST.get(i).origen + " " + MST.get(i).destino + " " + MST.get(i).peso);
		}

		// Si el MST encontrado no posee todos los vértices mostramos mensaje de error
		// Para saber si contiene o no todos los vértices basta con que el numero
		// de aristas sea igual al numero de vertices - 1
		if (tam - 1 != numAristas) {
			System.out.println("No existe MST valido para el grafo ingresado, el grafo debe ser conexo.");
			return;
		}
		System.out.println("-----El MST encontrado contiene las siguientes aristas-----");
		for (int i = 0; i < numAristas; ++i)
			System.out.printf("( %d , %d ) : %d\n", MST.get(i).origen, MST.get(i).destino, MST.get(i).peso); // ( vertice u ,
																									// vertice v ) :
																									// peso

		System.out.printf("El costo minimo de todas las aristas del MST es : %d\n", total);
		costoTotal = total;
	}

	/// UNION-FIND

	// Método de inicialización
	private void MakeSet( int n ){
	    for( int i = 1 ; i <= n ; ++i ) padres[ i ] = i;
	}

	// Método para encontrar la raiz del vértice actual X
	private int Find(int x) {
		return (x == padres[x]) ? x : (padres[x] = Find(padres[x]));
	}
	
	// Método para unir 2 componentes conexas
	private void Union(int x, int y) {
		padres[Find(x)] = Find(y);
	}

	// Método que me determina si 2 vértices estan o no en la misma componente
	// conexa
	private boolean sameComponent(int x, int y) {
		if (Find(x) == Find(y))
			return true;
		return false;
	}
	/// FIN UNION-FIND

	public int getCostoTotal() {
		return costoTotal;
	}

	public ArrayList<Camino> getMST() {
		return MST;
	}
	
}
