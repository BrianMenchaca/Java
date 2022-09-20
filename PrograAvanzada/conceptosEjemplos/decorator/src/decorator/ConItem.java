package decorator;

public abstract class ConItem extends Unidad {

	private Unidad decorado;
	
	public ConItem(Unidad decorado) {
		this.decorado = decorado;
	}
	
	@Override
	public int getDanio() {
		return decorado.getDanio();
	}

}
