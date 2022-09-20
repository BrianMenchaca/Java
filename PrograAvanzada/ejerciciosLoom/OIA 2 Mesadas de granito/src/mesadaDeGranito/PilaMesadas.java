package mesadaDeGranito;

public class PilaMesadas {

	private int anchoBase;
	private int largoBase;

	public PilaMesadas(int ancho, int largo) {
		this.anchoBase = ancho;
		this.largoBase = largo;
	}

	public boolean pudoApilarse(int largo, int ancho) {

		// Caso donde va por encima de la base de la pila
		if ((this.largoBase >= largo && this.anchoBase >= ancho) || (this.largoBase >= ancho && this.anchoBase >= largo))
			return true;

		// Caso donde se convierte en la base de la pila
		if ((this.largoBase <= largo && this.anchoBase < ancho) || (this.largoBase <= ancho && this.anchoBase < largo)) {
			this.anchoBase = ancho;
			this.largoBase = largo;
			return true;
		}
		
		// No se pudo apilar
		return false;
	}
}
