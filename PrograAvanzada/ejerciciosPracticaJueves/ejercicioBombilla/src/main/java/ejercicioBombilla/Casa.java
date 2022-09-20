package ejercicioBombilla;

public class Casa {

//	private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
//	private ArrayList habitaciones;
	private Habitacion[] habitaciones;
	
	public Bombilla bombillaMayorGasto() {
		
		Bombilla bombillaGasto = new Bombilla(0);
		
		for(Habitacion h: habitaciones) {
			bombillaGasto = bombillaGasto.mayorPotencia(h.bombillaMayorH());
		}
		return bombillaGasto;
	}
}
