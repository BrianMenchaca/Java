package sanandoLuchadores;

public class App {

	public static int ejercicio(String fileEntrada, String fileSalida) {

		int magia = 0;
		int total = 0;
		int[] vidaInicial = null;
		int[] vidaActual = null;
		int[] distancia = null;
		
		try {
			magia = EvaluadorLocal.leerEntrada(fileEntrada, vidaInicial, vidaActual, distancia);

			total = Sanador.sanar(magia, vidaInicial, vidaActual, distancia);
			EvaluadorLocal.escribirArchivo(fileSalida, total);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(total);
		return total;
	}
}
