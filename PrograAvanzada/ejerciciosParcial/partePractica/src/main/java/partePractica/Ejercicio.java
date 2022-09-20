package partePractica;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio {

//	public static void programa(String inputFilePath, String OutputFilePath) {
//		
//	}

	public static int cantidadMinimaAplicacionesEliminadas(String path) {

		int cantidadMinima = 0;
		FileReader file = null;
		Scanner scanner = null;

		try {
			file = new FileReader(path);
			scanner = new Scanner(file);

			int cantidadAplicaciones = scanner.nextInt();
			int tamanioAplicacion = scanner.nextInt();
			int sumaTamanioAplicaciones = 0;
			boolean primerCaso = true;

			int[] array = new int[cantidadAplicaciones];

			int posSale = 0;
			int i = 0;
			int ciclos = 0;

			do {

				System.out.println("ciclos: " + ciclos);
				while (sumaTamanioAplicaciones < tamanioAplicacion && i < cantidadAplicaciones) {
					array[i] = scanner.nextInt();
					sumaTamanioAplicaciones += array[i];
					i++;
					ciclos++;
					System.out.println("ciclos: " + ciclos);

				}

				if (sumaTamanioAplicaciones < tamanioAplicacion && (cantidadMinima > i - posSale || primerCaso)) {
					primerCaso = false;
					cantidadMinima = i - posSale - 1;
				}

				sumaTamanioAplicaciones -= array[posSale];

				if (posSale < i)
					posSale++;
				ciclos++;
			} while (i < cantidadAplicaciones);

//			for(int j = 0; j < cantidadAplicaciones; j++) {
//				System.out.print(array[j] + " ");
//			}
//			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		System.out.println(cantidadMinima);
		return cantidadMinima;
	}
}
