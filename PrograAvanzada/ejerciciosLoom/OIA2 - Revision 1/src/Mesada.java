
public class Mesada {
	int largo;
	int ancho;
	
	
	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}


	public int getLargo() {
		return largo;
	}


	public void setLargo(int largo) {
		this.largo = largo;
	}


	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	@Override
	public String toString() {
		return "Mesadas [largo=" + largo + ", ancho=" + ancho + "]";
	}
	
	
}
