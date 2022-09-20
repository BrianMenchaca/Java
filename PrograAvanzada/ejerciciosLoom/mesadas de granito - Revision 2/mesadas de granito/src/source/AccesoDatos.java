package source;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccesoDatos {
	private String nombreArchivo;

	public AccesoDatos(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public PilasDeMesadas procesarEntrada() {
		Scanner entrada = null;
		List<Mesada> mesadas = new ArrayList<Mesada>();
		try {
			entrada = new Scanner(new File("./in/" + this.nombreArchivo + ".in"));
			int cantMesadas = entrada.nextInt();
			for (int i = 0; i < cantMesadas; i++) {
				mesadas.add(new Mesada(entrada.nextInt(), entrada.nextInt()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entrada != null)
				entrada.close();
		}
		return new PilasDeMesadas(mesadas);
	}

	public void generarSalida(PilasDeMesadas pilas) {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new FileWriter("./out/" + this.nombreArchivo + ".out"));
			salida.println(pilas.resolver());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (salida != null)
			salida.close();
	}
}
