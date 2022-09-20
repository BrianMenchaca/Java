package mesadaDeGranito;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GestorArchivos {

	private static int CANTIDAD_MINIMA_NUMEROS = 1;
	private static int CANTIDAD_MAXIMA_NUMEROS = 10;
	private static int VALOR_MAXIMO_NUMERO = 10;
	private static int VALOR_MINIMO_NUMERO = 1;

	public static void generarNumerosAleatorios(String filePath) {

		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(filePath);
			printerWriter = new PrintWriter(file);
			Integer cantidadNumeros = (int) (Math.random() * (CANTIDAD_MAXIMA_NUMEROS + 1 - CANTIDAD_MINIMA_NUMEROS)
					+ CANTIDAD_MINIMA_NUMEROS);
			printerWriter.println(cantidadNumeros);

			for (int i = 0; i < cantidadNumeros; i++) {
				Integer nroAleatorio1 = (int) (Math.random() * (VALOR_MAXIMO_NUMERO + 1 - VALOR_MINIMO_NUMERO)
						+ VALOR_MINIMO_NUMERO);
				Integer nroAleatorio2 = (int) (Math.random() * (VALOR_MAXIMO_NUMERO + 1 - VALOR_MINIMO_NUMERO)
						+ VALOR_MINIMO_NUMERO);
				printerWriter.println(nroAleatorio1.toString() + " " + nroAleatorio2.toString());
			}

			System.out.println(cantidadNumeros.toString() + " numeros aleatorios fueron escritos en el archivo.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void escribirCantidadMinimaPilas(String filePath, int cantidadMinimaPilas) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(filePath);
			printerWriter = new PrintWriter(file);

			printerWriter.println(cantidadMinimaPilas);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
