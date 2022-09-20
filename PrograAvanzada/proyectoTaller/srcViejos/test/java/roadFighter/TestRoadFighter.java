package roadFighter;

//import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoadFighter {

	@Test
	public void test0() {
		Mapa mapa = new Mapa(10, 200, 0, 50000);
		mapa.generarObstaculos(12);
		for(int i = 0; i < 12; i++) {
			System.out.println("posicioX: " + mapa.obstaculos.get(i).posicionX);
			System.out.println("posicioY: " + mapa.obstaculos.get(i).posicionY);
			System.out.println("radio: " + mapa.obstaculos.get(i).radio);
		}
	}

}
