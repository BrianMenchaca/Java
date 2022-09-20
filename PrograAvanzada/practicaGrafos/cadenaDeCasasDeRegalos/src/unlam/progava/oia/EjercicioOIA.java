package unlam.progava.oia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioOIA {

	Grafo grafo;
	ArrayList<Integer> listaCiudades;
	
	public static void main(String[] args) throws IOException {
		EjercicioOIA ejercicio = new EjercicioOIA();
		
		ejercicio.leer("src/unlam/progava/oia/in/00.in");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/00.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la
	 * consigna desde el archivo.
	 * @thr
	 * ws IOException 
	 */
	public void leer(String path) throws IOException {
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader(new File(path)));
			int cant = scanner.nextInt();
			grafo = new Grafo(cant);
			
			int dato;
			for(int i = 0; i < cant; i++) {
				dato = scanner.nextInt();
				dato = scanner.nextInt();
				while(dato != -1) {
					grafo.setArista(i, dato - 1, 1);
					dato = scanner.nextInt();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IOException("Error");
		} finally {
			scanner.close();			
		}
		
	}
	
	/**
	 * Este método se encarga de escribir la salida de la
	 * consigna en el archivo.
	 * @throws IOException 
	 */
	public void escribir(String path) throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File(path)));
			
			bw.write(listaCiudades.size() + "");
			bw.newLine();
			for(int ciudad : listaCiudades) {
				bw.write(ciudad + " ");
			}
			
		} catch(Exception e) {
			throw new IOException(e.getMessage());
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
				// TODO: handle exception
				throw new IOException(e.getMessage());
			}
		}
	}
	
	/**
	 * Este método debe realizar la resolución del ejercicio.
	 * NO DEBE SITUARSE LA LOGICA AQUI, sino que se pueden
	 * utilizar clases adicionales, y los objetos creados en la
	 * etapa de lectura.
	 * Utilizar este mismo paquete para toda la resolución.
	 */
	public void resolver() {
		listaCiudades = grafo.coloreo();
	}
}
