package metro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorDeArchivo {

	private String nombre;
	private int tam;

	public int getTam() {
		return tam;
	}

	public GestorDeArchivo(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
	}

	public int[][] leerArchivo() {
		Scanner scanner = null;
		int[][] datos = null;

		try {
			File file = new File("casos de prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);

			int cant = scanner.nextInt();
			datos = new int[cant][cant];
			this.tam = cant;

			int cantTuneles = scanner.nextInt();
			int cantPuentes = scanner.nextInt();

			int origen;
			int destino;

			for (int i = 0; i < cant; i++) {
				for (int j = 0; j < cant; j++) {
					datos[i][j] = -1;
				}
			}

			for (int i = 0; i < cantTuneles; i++) {
				origen = scanner.nextInt() - 1;
				destino = scanner.nextInt() - 1;
				datos[origen][destino] = 0;
				datos[destino][origen] = 0;
			}

			for (int i = 0; i < cantPuentes; i++) {
				origen = scanner.nextInt() - 1;
				destino = scanner.nextInt() - 1;
				datos[origen][destino] = 1;
				datos[destino][origen] = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			scanner.close();
		}
		return datos;
	}

	public void guardarArchivo(int dato) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
			printerWriter = new PrintWriter(file);

			printerWriter.println(dato);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
