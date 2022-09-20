package unlam.progava.oia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Grafo {

	private int[][] matrizAdyacencia;
	private int[] gradoNodos;

	public Grafo(int tam) {
		// TODO Auto-generated constructor stub
		matrizAdyacencia = new int[tam][tam];
		gradoNodos = new int[tam];
	}

	public void setArista(int nodoInicial, int nodoFinal, int peso) {
		matrizAdyacencia[nodoInicial][nodoFinal] = peso;
		matrizAdyacencia[nodoFinal][nodoInicial] = peso;

		gradoNodos[nodoInicial]++;
		gradoNodos[nodoFinal]++;
	}

	public int getArista(int nodoInicial, int nodoFinal) {
		return matrizAdyacencia[nodoInicial][nodoFinal];
	}

	public ArrayList<Integer> getAdyacentes(int nodo) {
		ArrayList<Integer> adyacentes = new ArrayList<>();

		for (int i = 0; i < matrizAdyacencia.length; i++) {
			if (matrizAdyacencia[i][nodo] != 0) {
				adyacentes.add(i);
			}
		}
		return adyacentes;
	}

	public int getGradoNodo(int nodo) {
		return gradoNodos[nodo];
	}

	public ArrayList<Integer> coloreo() {
		int[] nodos = new int[matrizAdyacencia.length];
		PriorityQueue<Nodo> gradoNodos = new PriorityQueue<>();
		int cantidadColores = 0;
		
		for (int nodo = 0; nodo < nodos.length; nodo++) { // N
			gradoNodos.add(new Nodo(nodo, getGradoNodo(nodo))); // Get grado nodo tiene CC O(1)
		}
		
		Arrays.fill(nodos, -1);

		nodos[gradoNodos.poll().getNodo()] = 0;
		
		boolean available[] = new boolean[matrizAdyacencia.length];

		Arrays.fill(available, true);
		
		// Saco del menor grado
		while (!gradoNodos.isEmpty()) {
			Nodo nodo = gradoNodos.poll();

			ArrayList <Integer> adyacentes = getAdyacentes(nodo.getNodo()); // N

			for (int i : adyacentes) {
				if (nodos[i] != -1)
					available[nodos[i]] = false;
			}
			
			int color = 0;
			while(color < matrizAdyacencia.length && !available[color]) {
				color++;
			}

			if(cantidadColores < color)
				cantidadColores = color;
				
			nodos[nodo.getNodo()] = color; // Assign the found color

			// Reset the values back to true for the next iteration
			Arrays.fill(available, true);
		}
		
		HashMap <Integer, ArrayList<Integer>> mapaColores = new HashMap<>();
		for(int i = 0; i < nodos.length; i++) {
			if(!mapaColores.containsKey(nodos[i])) {
				ArrayList<Integer> lista = new ArrayList<>();
				lista.add(i);
				mapaColores.put(nodos[i], lista);
			} else {
				mapaColores.get(nodos[i]).add(i);
			}
		}
		
		int max = 0;
		int colorMax = 0;
		for(Integer color : mapaColores.keySet()) {
			int aux = mapaColores.get(color).size();
			if(aux > max) {
				colorMax = color;
				max = aux;
			}
		}
		
		return mapaColores.get(colorMax);
	}

}
