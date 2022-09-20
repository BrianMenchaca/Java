package ejercicioLuchadoresJaponeses;

public class Luchador {
	private int altura;
	private int peso;

	Luchador(int altura, int peso) {
		this.altura = altura;
		this.peso = peso;
	}
	
	public boolean dominar(Luchador otroLuchador) {
		if((this.altura >= otroLuchador.altura && this.peso > otroLuchador.peso) ||
				(this.altura > otroLuchador.altura && this.peso >= otroLuchador.peso))
			return true;
		
		return false;
	}

}
