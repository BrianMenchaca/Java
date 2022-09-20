package ejercicioBombilla;

//import ejercicioBombilla.Bombilla.*;

public class Habitacion {

//	private ArrayList<Bombilla> bombillas = new ArrayList<Bombilla>();
	private Bombilla[] bombillas;
	
	public Bombilla bombillaMayorH() {
		Bombilla bombillaGasto = new Bombilla(0);
		for(Bombilla b: bombillas) {
			bombillaGasto = bombillaGasto.mayorPotencia(b);
		}
		return bombillaGasto;
	}
}