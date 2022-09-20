package ejercicio00Revision2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirculoTest {

	@Test
	public void test1() {
		/*
		 * Si la distancia entre los centros es mayor a la suma de sus radios no se
		 * cortan/interceptan los circulos
		 */

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);

		assertEquals(c1.intersectaCon(c2), true);

	}

	@Test
	public void test2() {
		/*
		 * Si la distancia en los centros es 0 y tienen distinto radio, las
		 * circunferencias nunca se van a interceptar.
		 */

		Circulo c1 = new Circulo(new Punto(0, 0), 2);
		Circulo c2 = new Circulo(new Punto(0, 0), 5);

		assertEquals(c1.intersectaCon(c2), false);

	}

	@Test
	public void test3() {
		/* Si las circunferencias son iguales interceptan en infinitos puntos */
		Circulo c1 = new Circulo(new Punto(0, 0), 2);
		Circulo c2 = new Circulo(new Punto(0, 0), 2);

		assertEquals(c1.intersectaCon(c2), true);

	}
	
	@Test
	// Caso de no interseccion
	public void test4() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(3, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

//		System.out.println(c1.intersectaCon(c2)); // true

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso de interseccion en 2 puntos
	public void test5() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(2, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso interseccion en un solo punto
	public void test6() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(4, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso mismo centro pero distinto radio
	public void test7() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso circulos superpuestos
	public void test8() {

		Circulo c1 = new Circulo(new Punto(1, 2), 5);
		Circulo c2 = new Circulo(new Punto(1, 1), 1);
		assertEquals(c1.intersectaCon(c2), false);
	}
}
