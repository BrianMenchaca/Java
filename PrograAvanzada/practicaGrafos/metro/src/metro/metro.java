package metro;

public class metro {
	public static void main(String[] args) {

		GestorDeArchivo gestorDeArchivo = new GestorDeArchivo("prueba1");
		int matriz[][] = gestorDeArchivo.leerArchivo();
		AlgoritmoKruskal algoritmo = new AlgoritmoKruskal(matriz, gestorDeArchivo.getTam());
		algoritmo.KruskalMST();
		gestorDeArchivo.guardarArchivo(algoritmo.getCostoTotal());
	}
}
