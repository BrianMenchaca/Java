package ejercicioLuchadoresJaponeses;

import java.io.File;
import java.util.Scanner;

public class GestorArchivos {

	public static Torneo crearTorneo(String ruta) {
		
		Scanner rarch = new Scanner(new File(ruta));
		
		Torneo torneo = new Torneo(rarch.nextInt());
		
		while(rarch.hasNext()) {
			Luchador luchador = new Luchador(rarch.nextInt(), rarch.nextInt());
			try {
				torneo.agregarLuchador(luchador);
		} catch(Exception TorneoLleno) {
			System.out.println(TorneoLleno.getMessage());
			}
		}
		
		return torneo;
	}
	
}
