package ejercicio00;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirculoTests {

	@Test
	// Caso de no interseccion
	public void test() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(3, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

//		System.out.println(c1.intersectaCon(c2)); // true

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso de interseccion en 2 puntos
	public void test1() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(2, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso interseccion en un solo punto
	public void test2() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(4, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso mismo centro pero distinto radio
	public void test3() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso circulos superpuestos
	public void test4() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 1);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
}