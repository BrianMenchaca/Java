package roadFighter;

public class Obstaculo implements Comparable<Obstaculo> {

	protected Integer posicionX;
	protected Integer posicionY;
	protected double radio;

	public Obstaculo(Integer posicionX, Integer posicionY, double radio) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.radio = radio;
	}

	public int compareTo(Obstaculo o) {
		// TODO Auto-generated method stub
		if (this.posicionY < o.posicionY) {
            return -1;
        } else if (this.posicionY > o.posicionY) {
            return 1;
        }
		return 0;
        
	}

	public void efecto(Auto auto) {
		auto.frenar();
		auto.moverseHorizontal(Math.random());
		// El auto se movera horizontalmente, la clase Auto definira si choca con el
		// borde del mapa o otro auto.

	}
	
}
