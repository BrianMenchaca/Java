package ejercicio00Revision2;

public class Circulo extends Punto {

	private double radio;

	public Circulo(Punto p, double radio) {
		super(p.x, p.y);
//		this.x = p.x;
//		this.y = p.y;
		this.radio = radio;
	}

	public boolean intersectaCon(Circulo c2) {

		/* Si las circunferencias son iguales interceptan en infinitos puntos */
		if (radio == c2.radio && x == c2.x && y == c2.y)
			return true;

		double distanciaEntreC = Math.sqrt(Math.pow(x - (c2.x), 2) + Math.pow(y - (c2.y), 2));
		/*
		 * Si la distancia en los centros es 0 y tienen distinto radio, las
		 * circunferencias nunca se van a interceptar.
		 */
		if (distanciaEntreC == 0)
			return false;
		/*
		 * Si la distancia entre los centros es mayor a la suma de sus radios no se
		 * cortan/interceptan los circulos
		 */

		double radioTotal = radio + c2.radio;
		if (distanciaEntreC > radioTotal)
			return false;
		else
			return true;
	}

//	public static void main(String[] args) {
//		Circulo c1 = new Circulo(new Punto(-1, -1), 2);
//		Circulo c2 = new Circulo(new Punto(1, 1), 5);
//
//		System.out.println(c1.intersectaCon(c2));
//	}

}