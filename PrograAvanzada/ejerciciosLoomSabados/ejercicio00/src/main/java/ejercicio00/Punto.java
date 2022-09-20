package ejercicio00;

public class Punto {

	private double x, y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Punto(Punto otroPunto) {
		super();
		this.x = otroPunto.x;
		this.y = otroPunto.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}