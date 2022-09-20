package ejercicio00Revision1;

public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo(Punto punto, double radio) {
		super();
		this.centro = new Punto(punto);
//		this.centro = new Punto(punto.getX(), punto.getY());
		this.radio = radio;
	}
	
	public boolean intersectaCon(Circulo c) {
		double distanciaEntreCentros = this.centro.calcularDistancia(c.centro);
		double sumaRadios = this.radio + c.radio;
		double diferenciaRadios = Math.abs(this.radio - c.radio);
		
		if(distanciaEntreCentros > sumaRadios) {
			return false;
		}
		
		if(distanciaEntreCentros == sumaRadios) {
			return true;
		} 
		
		if(distanciaEntreCentros < sumaRadios && distanciaEntreCentros > diferenciaRadios) {
			return true;
		}
		
		if(distanciaEntreCentros == diferenciaRadios) {
			return true;
		}
		
		if(distanciaEntreCentros < diferenciaRadios) {
			return false;
		} 
		
		if(distanciaEntreCentros == 0.0) {
			return false;
		}
		
		return true;
	}
}
