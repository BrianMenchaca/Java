package partePractica;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		String path = "entrada/almacenamiento.in";
		
		assertEquals(Ejercicio.cantidadMinimaAplicacionesEliminadas(path), 1);
	}

	@org.junit.Test
	public void test2() {
		String path = "entrada/entrada2.in";
		
		assertEquals(Ejercicio.cantidadMinimaAplicacionesEliminadas(path), 1);
	}
}
