package ejercicio00;

public class Circulo {

	private Punto centro;
	private double radio;

	public Circulo(Punto centro, double radio) {
		super();
		this.centro = new Punto(centro);
		this.radio = radio;
	}

	public boolean intersectaCon(Circulo c2) {

		// Ecuación de un círculo
		// (X - a)^2 + (Y - b)^2 = r

		// Círculo 1:
		double a1 = this.centro.getX();
		double b1 = this.centro.getY();
		double r1 = this.radio;

		// Círculo 2:
		double a2 = c2.centro.getX();
		double b2 = c2.centro.getY();
		double r2 = c2.radio;

		if (b1 == b2) { // Pregunta si b1 = b2

			if (a1 == a2) // Pregunta si se trata del mismo punto centro
				return r1 == r2 ? true : false; // Pregunta si ambos circulos estan superpuestos
			else {
				double v = (Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(a1, 2) + Math.pow(a2, 2)) / (-2 * a1 + 2 * a2);
				double izq = Math.pow(r1, 2);
				double der = Math.pow(v - a1, 2);

//				System.out.println("izq: " + izq);
//				System.out.println("der: " + der);

				return izq >= der ? true : false;
			}
		}

		// Primero tengo qe armar una recta que cruce por las intersecciones de existir.

		// Ecuación de la recta:
		// y = pendiente * x + ordenada

		double pendiente = (2 * a1 - 2 * a2) / (-2 * b1 + 2 * b2);
		double ordenada = (Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(a1, 2) + Math.pow(a2, 2) - Math.pow(b1, 2)
				+ Math.pow(b2, 2)) / (-2 * b1 + 2 * b2);

//		System.out.println("pendiente: " + pendiente);
//		System.out.println("ordenada: " + ordenada);

		// esto lo reemplazo en el Y de la ecuacion del circulo del primer circulo y me
		// queda una ecuacion cuadratica como resultado.
		// Entonces resuelvo por la formula cuadratica, para que exista una o dos
		// intersecciones en los circulos,
		// el termino (b^2 - 4 * a * c) tiene que ser mayor o igual que 0.
		double a = 1 + Math.pow(pendiente, 2);
		double b = -2 * a1 + 2 * pendiente * ordenada - 2 * b1 * pendiente;
		double c = Math.pow(a1, 2) + Math.pow(ordenada, 2) - Math.pow(b1, 2) - Math.pow(r1, 2);

//		System.out.println("a: " + a);
//		System.out.println("b: " + b);
//		System.out.println("c: " + c);

		double izq = Math.pow(b, 2);
		double der = 4 * a * c;

//		System.out.println("izq: " + izq);
//		System.out.println("der: " + der);
//		System.out.println();

		return izq >= der ? true : false;
	}
}
