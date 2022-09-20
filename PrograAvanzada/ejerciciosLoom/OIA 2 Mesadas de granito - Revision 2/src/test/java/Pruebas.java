import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class Pruebas {

	@Test
	public void prueba00_contar_pilas() {
		String nombre = "00";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void prueba01_apilar_correctamente() {
		String nombre = "01";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void prueba02_unica_mesada() {
		String nombre = "02";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void prueba03_unica_pila() {
		String nombre = "03";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void prueba04_pilas_por_cada_mesada() {
		String nombre = "04";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void prueba05_maximas_mesadas() {
		String nombre = "05";
		AccesoDatos datos = new AccesoDatos(nombre);
		PilasDeMesadas pilas = datos.procesarEntrada();
		datos.generarSalida(pilas);
		try {
			byte[] b1 = Files.readAllBytes(Paths.get("./out/" + nombre + ".out"));
			byte[] b2 = Files.readAllBytes(Paths.get("./out esperado/" + nombre + ".out"));
			assertArrayEquals(b1,b2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	


}
