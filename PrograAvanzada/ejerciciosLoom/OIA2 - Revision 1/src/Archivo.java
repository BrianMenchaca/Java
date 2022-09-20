import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

	public static ArrayList<Mesada> leerArchivo(String entrada) {
		try {

			Scanner arch = new Scanner(new File(entrada));

			String cantidad = arch.nextLine();
		
			ArrayList<Mesada> mesadas = new ArrayList <Mesada>();

			
			int i = 0;
			while (arch.hasNextLine()) {
				String linea = arch.nextLine();
				String vec[] = linea.split(" ");
				mesadas.add(i,new Mesada(Integer.parseInt(vec[0]), Integer.parseInt(vec[1])));
				i++;
			}
			arch.close();
			return mesadas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	
	public static void escribirArhivo(String salida, int cantidad) {

		try {
			
			PrintWriter pw = new PrintWriter(new File(salida));
			pw.print(cantidad);
			pw.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
