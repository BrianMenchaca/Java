package dijkstra;

public class Dikjstra {

	private int vertices;

	void dijkstra(int graph[][], int src) {

		int dist[] = new int[vertices];
		Boolean sptSet[] = new Boolean[vertices];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < vertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < vertices - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < vertices; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
	}

	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < vertices; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	public static double[] dijkstra_2(Grafo g, int nodoInicial) {
		double[] distancias = new double[g.getNodos()];
		int[] vectorPrecedencia = new int[g.getNodos()];
		boolean[] vectorRecorridos = new boolean[g.getNodos()];

		// Inicializo vectores
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Double.MAX_VALUE;
			// vectorPrecedencia[i] = Integer.MAX_VALUE;
			vectorPrecedencia[i] = nodoInicial;
			vectorRecorridos[i] = false;
		}

		// Inicializo vector de distancias
		distancias[nodoInicial] = 0;
		// vectorPrecedencia[nodoInicial] = -1;

		for (int count = 0; count < g.getNodos() - 1; count++) {
			int nodoMenorArista = getAristaMenorPeso(distancias, vectorRecorridos);

			vectorRecorridos[nodoMenorArista] = true;

			for (int nodo = 0; nodo < g.getNodos(); nodo++)
				if (!vectorRecorridos[nodo] && g.getArista(nodo, nodoMenorArista) != 0
						&& distancias[nodoMenorArista] != Integer.MAX_VALUE
						&& distancias[nodoMenorArista] + g.getArista(nodo, nodoMenorArista) < distancias[nodo]) {
					distancias[nodo] = distancias[nodoMenorArista] + g.getArista(nodo, nodoMenorArista);
					vectorPrecedencia[nodo] = nodoMenorArista;
				}
		}
		return distancias;
	}

	private static int getAristaMenorPeso(double[] distancias, boolean[] vecRecorridos) {
		int indiceNodo = -1;
		double menorCosto = Double.MAX_VALUE;

		for (int nodo = 0; nodo < distancias.length; nodo++)
			if (!vecRecorridos[nodo] && distancias[nodo] <= menorCosto) {
				menorCosto = distancias[nodo];
				indiceNodo = nodo;
			}
		return indiceNodo;
	}
}
