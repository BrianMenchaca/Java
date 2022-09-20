package ej4;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;

public class Arch {

	public static void leerArch(String path) {
		String linea;
		try {
//			File file = new File(path);
//			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader buffer = new BufferedReader(new FileReader(path));
			linea = buffer.readLine();
			while (linea == null) {
				linea = buffer.readLine();
				System.out.println(linea);
			}
			System.out.println("leido");
			buffer.close();
		} catch (IOException e) {
			System.out.println("Exception");
		} finally {
			System.out.println("---");
		}
		System.out.println("Terminó");
	}
}