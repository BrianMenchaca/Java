package ejercicio00Revision1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiguraTest {

	// Secantes
	@Test
	public void test1() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		boolean esperado = true;

		assertEquals(c1.intersectaCon(c2), esperado);
	}

	// Exteriores (no intersecan)
	@Test
	public void test2() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(2, 2), 1.6);
		boolean interseca = c1.intersectaCon(c2);
		boolean esperado = false;

		assertEquals(interseca, esperado);
	}

	// Tangentes exteriores
	@Test
	public void test3() {
		Circulo c1 = new Circulo(new Punto(0, 0), 0.5);
		Circulo c2 = new Circulo(new Punto(0, 1), 0.5);
		boolean interseca = c1.intersectaCon(c2);
		boolean esperado = true;

		assertEquals(interseca, esperado);
	}

	// Tangentes interiores
	@Test
	public void test4() {
		Circulo c1 = new Circulo(new Punto(1, 1), 2);
		Circulo c2 = new Circulo(new Punto(1, 2), 1);
		boolean interseca = c1.intersectaCon(c2);
		boolean esperado = true;

		assertEquals(interseca, esperado);
	}

	// Concentricas
	@Test
	public void test5() {
		Circulo c1 = new Circulo(new Punto(5, 5), 2);
		Circulo c2 = new Circulo(new Punto(5, 5), 3);
		boolean interseca = c1.intersectaCon(c2);
		boolean esperado = false;

		assertEquals(interseca, esperado);
	}

	// Interiores
	@Test
	public void test6() {
		Circulo c1 = new Circulo(new Punto(5, 5), 2);
		Circulo c2 = new Circulo(new Punto(5, 4), 4);
		boolean interseca = c1.intersectaCon(c2);
		boolean esperado = false;

		assertEquals(interseca, esperado);
	}
	
	@Test
	// Caso de no interseccion
	public void test7() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(3, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

//		System.out.println(c1.intersectaCon(c2)); // true

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso de interseccion en 2 puntos
	public void test8() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(2, 1), 1.5);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso interseccion en un solo punto
	public void test9() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(4, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso mismo centro pero distinto radio
	public void test10() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 3);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	// Caso circulos superpuestos
	public void test11() {

		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 0), 1);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = true;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	// Caso circulos superpuestos
	public void test12() {

		Circulo c1 = new Circulo(new Punto(1, 2), 5);
		Circulo c2 = new Circulo(new Punto(1, 1), 1);

		boolean resultadoObtenido = c1.intersectaCon(c2);
		boolean resultadoEsperado = false;

		assertEquals(resultadoEsperado, resultadoObtenido);
	}
}
