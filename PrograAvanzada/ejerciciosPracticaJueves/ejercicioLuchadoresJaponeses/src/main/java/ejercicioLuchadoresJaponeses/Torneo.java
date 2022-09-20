package ejercicioLuchadoresJaponeses;

public class Torneo {

	private int[] dominados;
	private Luchador[] luchadores;

	public Torneo(int cantidad) {
		luchadores = new Luchador[cantidad];
	}

	public boolean agregarLuchador(Luchador luchador) {
		int i = 0;
		while(luchadores[i] != null) {
			i++;
		}
		if(i == luchadores.length) {
			throw new TorneoLleno(); 
		}
		luchadores[i] = luchador;
		
		return true;
	}
}
