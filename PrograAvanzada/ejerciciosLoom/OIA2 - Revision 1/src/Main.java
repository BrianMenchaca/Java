import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		final String ENTRADA = "mesadas.in";
		final String SALIDA = "mesadas.out";

		ArrayList<Mesada> mesadas = new ArrayList<Mesada>();
		mesadas = Archivo.leerArchivo(ENTRADA);

		int cont = 0;
		boolean flag = false;
		
		Collections.sort();
		

		for (int i = 0; i < mesadas.size(); i++) {
			for (int j = i + 1; j < mesadas.size() - i; j++) {
				if (mesadas.get(j).getLargo() <= mesadas.get(j).getLargo()
						&& mesadas.get(j).getAncho() <= mesadas.get(j).getAncho()) {
					mesadas.remove(j);
					flag = true;
				} else if (mesadas.get(i).getAncho() <= mesadas.get(i).getLargo()
						&& mesadas.get(j).getLargo() <= mesadas.get(j).getAncho()) {
					mesadas.remove(j);
					flag = true;
				}

			}
			if (flag) {
				cont++;
			}
		}

		System.out.println("Contador");
		System.out.println(cont);
		
		Archivo.escribirArhivo(SALIDA, cont);

	}

}
