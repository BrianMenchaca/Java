package patronState;

public class Tanque {

//	private String modo = "normal";
	private ModoTanque modo = new ModoNormal();
	private String piloto;

	public Tanque(String piloto) {
		super();
		this.piloto = piloto;
	}
	
	public Tanque() {
		super();
	}
	

//	public void modoNormal() {
//		this.modo = "normal";
//	}
//	
//	public void modoAsedio() {
//		this.modo = "asedio";
//	}

	public void cambiarModo() {
		this.modo = this.modo.cambiarModo();
	}

	public void moverse() {
//		if (this.modo.equals("normal")) {
//			System.out.println("Me muevo");
//		} else {
//			System.out.println("No puedo moverme");
//		}
		this.modo.moverse();
			
	}

	public void atacar() {
//		if (this.modo.equals("normal")) {
//			System.out.println("Hago 10 de danio");
//		} else {
//			System.out.println("Hago 20 de danio");
//		}
//		if(this.modo.enemigoEnRango(enemigo))
//			this.modo.atacar(enemigo);
		this.modo.atacar();
	}
}
