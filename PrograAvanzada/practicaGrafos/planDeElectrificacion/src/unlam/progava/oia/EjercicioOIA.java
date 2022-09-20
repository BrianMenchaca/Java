package unlam.progava.oia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioOIA {
	private int cantVertices;
	private int[][] MA;
	private int[] ciudadesConCentralElectrica;
	private int  costoTendido;
	private ArrayList<Arista> aristasUsadas;

	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();

		ejercicio.leer("src/unlam/progava/oia/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/00.out");
		
		ejercicio.leer("src/unlam/progava/oia/in/01.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/01.out");
		
		ejercicio.leer("src/unlam/progava/oia/in/02.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/02.out");
		
		ejercicio.leer("src/unlam/progava/oia/in/03.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/03.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la consigna desde el archivo.
	 */
	public void leer(String path) {

		Scanner scanner = null;
		MA = null;

		try {
			File file = new File(path);
			scanner = new Scanner(file);

			cantVertices = scanner.nextInt();
			MA = new int[cantVertices][cantVertices];
			int cantidadDeCiudadesConCentralElectrica = scanner.nextInt();
			this.ciudadesConCentralElectrica = new int[cantidadDeCiudadesConCentralElectrica];

			for (int i = 0; i < cantidadDeCiudadesConCentralElectrica; i++)
				this.ciudadesConCentralElectrica[i] = scanner.nextInt();

			for (int i = 0; i < cantVertices; i++)
				for (int j = 0; j < cantVertices; j++)
					MA[i][j] = scanner.nextInt();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scanner.close();
		}
	}

	/**
	 * Este método se encarga de escribir la salida de la consigna en el archivo.
	 */
	public void escribir(String path) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		try {
			file = new FileWriter(path);
			printerWriter = new PrintWriter(file);
			
			printerWriter.println(costoTendido);
			
			for(Arista arista: aristasUsadas) {
				printerWriter.println(arista.origen + " " + arista.destino);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Este método debe realizar la resolución del ejercicio. NO DEBE SITUARSE LA
	 * LOGICA AQUI, sino que se pueden utilizar clases adicionales, y los objetos
	 * creados en la etapa de lectura. Utilizar este mismo paquete para toda la
	 * resolución.
	 */
	public void resolver() {
		AlgoritmoKruskal kruskal = new AlgoritmoKruskal(MA, cantVertices, ciudadesConCentralElectrica);
		kruskal.KruskalMST();
		costoTendido = kruskal.getCostoTotal();
		aristasUsadas = kruskal.getMST();
	}
}
