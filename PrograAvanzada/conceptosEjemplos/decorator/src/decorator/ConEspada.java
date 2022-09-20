package decorator;

public class ConEspada extends ConItem {

	public ConEspada(Unidad decorado) {
		super(decorado);
	}
	
	@Override
	public int getDanio() {
		return super.getDanio() + 10;
	}

}
