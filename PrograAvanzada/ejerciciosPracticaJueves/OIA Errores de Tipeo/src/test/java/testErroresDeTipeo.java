import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testErroresDeTipeo {

	@Test
	public void test() {
		String texto = new String("Estamos pintando!");
		String prueba = new String("ostant!Em inpados");
		Assert.assertEquals(ErroresDeTipeo.procesarTexto(texto.toCharArray(), prueba.toCharArray()), 40);
	}

}
