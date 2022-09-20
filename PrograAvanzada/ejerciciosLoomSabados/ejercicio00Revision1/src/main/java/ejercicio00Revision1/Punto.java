package ejercicio00Revision1;

public class Punto {
	private double x;
	private double y;
	
//	public Punto(){
//		super();
//		this.x = 0;
//		this.y = 0;
//	}
	
	public Punto(Punto p) {
		super();
		this.x = p.x;
		this.y = p.y;
	}
	
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
//	public Punto suma(Punto punto1) {
//		return new Punto(this.x + punto1.x, this.y + punto1.y);
//	}
	
//	public void desplazar(double despX, double despY) {
//		this.x += despX;
//		this.y += despY;
//	}
	
//	public double getX() {
//		return this.x;
//	}
	
//	public double getY() {
//		return this.y;
//	}

	public double calcularDistancia(Punto punto) {
		return Math.hypot(this.x - punto.x, this.y - punto.y);
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Punto other = (Punto) obj;
//
//		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
//				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
//	}

//	@Override
//	public String toString() {
//		return "Punto [x=" + x + ", y=" + y + "]";
//	}
}
