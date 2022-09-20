package sanadoLuchadores;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import org.junit.Test;
import sanandoLuchadores.App;
import sanandoLuchadores.EvaluadorLocal;

public class TestApp {

	@Test
	public void test() throws FileNotFoundException {
		String fileEntrada = "C:\\Users\\menbr\\Desktop\\GitHub\\PrograAvanzada\\OIA\\sanandoLuchadores\\archivos/caso1.in";
		String fileSalida = "archivos/caso1.out";
		String fileSalidaEsperada = "archivos/caso1Esperado.out";

		assertEquals(App.ejercicio(fileEntrada, fileSalida), EvaluadorLocal.leerSalidaEsperada(fileSalidaEsperada));
	}
}
