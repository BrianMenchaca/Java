package jugandoConDivisores;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorDeArchivos {

	public static int lecturaArchivo(String path) {
	
		File file = null;
		Scanner scanner = null;
		int numeroPizarron = 0;
		
		try {
			file = new File(path);
			scanner = new Scanner(file);
			
			numeroPizarron = scanner.nextInt();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				try {
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return numeroPizarron;
	}
	
	public static int[] lecturaArchivoTest(String path) {
		
		File file = null;
		Scanner scanner = null;
		
		int[] resultadoEsperado = {0,0};
		
		try {
			file = new File(path);
			scanner = new Scanner(file);
			
			resultadoEsperado[0] = scanner.nextInt();
			resultadoEsperado[1] = scanner.nextInt();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				try {
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resultadoEsperado;
	}
	
	public static void grabarArchivo(String path, int[] resultados) {
		
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
			file = new FileWriter(path);
			printerWriter = new PrintWriter(file);
			
			printerWriter.println(resultados[0] + " " + resultados[1]);
		} catch (Exception e) {
			// TODO: handle exception
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
