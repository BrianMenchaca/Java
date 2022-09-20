package decorator;

public class ConAmuleto extends ConItem {

	public ConAmuleto(Unidad decorado) {
		super(decorado);
	}

	@Override
	public int getDanio() {
		return super.getDanio() * 3;
	}
}
