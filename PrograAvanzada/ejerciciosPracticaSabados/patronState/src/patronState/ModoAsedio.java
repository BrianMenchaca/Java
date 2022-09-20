package patronState;

public class ModoAsedio extends ModoTanque { 
	
	@Override
	public void atacar() {
		System.out.println("20 de danio");
	}
	
	@Override
	public void moverse() {
		System.out.println("nope"); // *
	}
	
	@Override
	public ModoTanque cambiarModo() {
		return new ModoNormal();
	}

}
