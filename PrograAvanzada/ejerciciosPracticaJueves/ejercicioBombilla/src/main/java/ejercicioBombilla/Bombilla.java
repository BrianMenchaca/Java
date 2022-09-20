package ejercicioBombilla;

public class Bombilla {

	private int potencia;
	
	public Bombilla(int potencia) {
		super();
		this.potencia = potencia;
	}
//
//	public int getPotencia() {
//		return potencia;
//	}
	
	public Bombilla mayorPotencia(Bombilla otra) {
		if(this.potencia>otra.potencia) {
			return this;
		} else {
			return otra;
		}
	}
}