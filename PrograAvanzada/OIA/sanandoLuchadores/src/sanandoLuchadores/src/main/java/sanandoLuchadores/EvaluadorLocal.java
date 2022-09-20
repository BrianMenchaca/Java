package sanandoLuchadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EvaluadorLocal {

	public static int leerEntrada(String filePath, int[] vidaInicial, int[] vidaActual, int[] distancia)
			throws FileNotFoundException {

		File file = null;
		Scanner scanner = null;
		int magia = 0;

		try {
			// APERTURA DE ARCHIVO
			file = new File(filePath);
			scanner = new Scanner(file);

			// LECTURA DE ARCHIVO
			int n = scanner.nextInt();
			System.out.println(n);
			vidaActual = new int[n];
			vidaInicial = new int[n];
			distancia = new int[n];
			
			magia = scanner.nextInt();
			System.out.println(magia);
			

			for (int i = 0; i < n; i++) {
				vidaInicial[i] = scanner.nextInt();
				vidaActual[i] = scanner.nextInt();
				distancia[i] = scanner.nextInt();
				System.out.println(vidaInicial[i] + " " + vidaActual[i] + " " + distancia[i]);
			}

		} finally {
			scanner.close();
		}

		return magia;
	}
	
	public static int leerSalidaEsperada(String filePath)
			throws FileNotFoundException {

		File file = null;
		Scanner scanner = null;
		int total = 0;

		try {
			// APERTURA DE ARCHIVO
			file = new File(filePath);
			scanner = new Scanner(file);

			// LECTURA DE ARCHIVO
			total = scanner.nextInt();


		} finally {
			scanner.close();
		}

		return total;
	}

	public static void escribirArchivo(String filePath, int CantidadDePuntosDeVidaTotal) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(filePath);
			printerWriter = new PrintWriter(file);

			printerWriter.println(CantidadDePuntosDeVidaTotal);
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
