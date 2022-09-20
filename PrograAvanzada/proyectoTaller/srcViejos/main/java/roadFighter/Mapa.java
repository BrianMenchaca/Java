package roadFighter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapa{
	
	protected double bordeIzquierdo;
	protected double bordeDerecho;

	protected double inicio;
	protected double fin;

	protected List<Obstaculo> obstaculos = null;

	public Mapa(double bordeIzquierdo, double bordeDerecho, double inicio, double fin) {
		
		this.bordeIzquierdo = bordeIzquierdo;
		this.bordeDerecho = bordeDerecho;
		this.inicio = inicio;
		this.fin = fin;
		this.obstaculos = null;
	}

	public void generarObstaculos(int cantidadObstaculos) {

		double inicioDeObstaculos = (this.fin - this.inicio) * 0.01;
		int radioMinimo = 5;
		int radioMaximo = 10;

		Integer posicionX;
		Integer posicionY;
		double radioObstaculo;
		obstaculos = new ArrayList<Obstaculo>();
		
		for (int i = 0; i < cantidadObstaculos; i++) {
			posicionX = (int) (Math.random() * (bordeDerecho + 1 - bordeIzquierdo) + bordeIzquierdo);
			posicionY = (int) (Math.random() * (this.fin + 1 - inicioDeObstaculos) + inicioDeObstaculos);
			radioObstaculo = (Math.random() * (radioMaximo + 1 - radioMinimo) + radioMinimo);
			obstaculos.add(new Obstaculo(posicionX, posicionY, radioObstaculo));
		}
		
		Collections.sort(obstaculos);
	}
	
	public void generarNpc(int cantidadObstaculos) {

		double inicioDeObstaculos = (this.fin - this.inicio) * 0.01;
		int radioMinimo = 5;
		int radioMaximo = 10;

		Integer posicionX;
		Integer posicionY;
		double radioObstaculo;
		obstaculos = new ArrayList<Obstaculo>();
		
		for (int i = 0; i < cantidadObstaculos; i++) {
			posicionX = (int) (Math.random() * (bordeDerecho + 1 - bordeIzquierdo) + bordeIzquierdo);
			posicionY = (int) (Math.random() * (this.fin + 1 - inicioDeObstaculos) + inicioDeObstaculos);
			radioObstaculo = (Math.random() * (radioMaximo + 1 - radioMinimo) + radioMinimo);
			obstaculos.add(new Obstaculo(posicionX, posicionY, radioObstaculo));
		}
		
		Collections.sort(obstaculos);
	}
	
}
