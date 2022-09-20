
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MesadasMain {
	public static void main(String[] args) {
		String nombre = "03";
		AccesoDatos entrada = new AccesoDatos(nombre);
		PilasDeMesadas pilas = entrada.procesarEntrada();
		int cantPilas = pilas.resolver();
		entrada.generarSalida(pilas);
		System.out.println(cantPilas);
		 pilas.mostrarMesadas();
	}

	//usar este metodo para generar los datos del archivo 05.in
	public static void generarArchivo(String nombre) {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new FileWriter("./in/" + nombre + ".in"));
			for (int i = 1; i <= 200000; i++) {
				salida.println(i + " " + i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (salida != null)
			salida.close();
	}
}
