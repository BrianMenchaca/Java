package jugandoConDivisores;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrograma {

	@Test
	public void test1() {
		
		String inputFilePath = "entradas/caso1.in";
		String outputFilePath = "salidas/caso1.out";
		String outputExpectedFilePath = "esperadas/caso1.expected";
		
		JugandoConDivisores.programa(inputFilePath, outputFilePath);
		assertArrayEquals(GestorDeArchivos.lecturaArchivoTest(outputFilePath), GestorDeArchivos.lecturaArchivoTest(outputExpectedFilePath));
	}
	
	@Test
	public void test2() {
		
		String inputFilePath = "entradas/caso2.in";
		String outputFilePath = "salidas/caso2.out";
		String outputExpectedFilePath = "esperadas/caso2.expected";
		
		JugandoConDivisores.programa(inputFilePath, outputFilePath);
		assertArrayEquals(GestorDeArchivos.lecturaArchivoTest(outputFilePath), GestorDeArchivos.lecturaArchivoTest(outputExpectedFilePath));
	}

}
