package mesadaDeGranito;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MesadaDeGranito {

	public static void determinarPilasMinimas(String inputFilePath, String outputFilePath) {
		Scanner scanner = null;
		int ancho;
		int largo;
		boolean seApilo = false;

		try {
			File file = new File(inputFilePath);
			scanner = new Scanner(file);

			List<PilaMesadas> listaPilas = new ArrayList<PilaMesadas>();

			int cant = scanner.nextInt();

			for (int i = 0; i < cant; i++) {

				ancho = scanner.nextInt();
				largo = scanner.nextInt();

				int j = 0;

				while (j < listaPilas.size() && !seApilo) {
					seApilo = listaPilas.get(j).pudoApilarse(largo, ancho);
					j++;
				}

				// Se debe crear una nueva pila
				if (!seApilo) {
					listaPilas.add(new PilaMesadas(ancho, largo));
				}

				seApilo = false;
			}

			GestorArchivos.escribirCantidadMinimaPilas(outputFilePath, listaPilas.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void main(String[] args) {

		String inputFilePath = "archivos/mesadas.in";
		String outputFilePath = "archivos/mesadas.out";
		GestorArchivos.generarNumerosAleatorios(inputFilePath);

		determinarPilasMinimas(inputFilePath, outputFilePath);
	}
}
