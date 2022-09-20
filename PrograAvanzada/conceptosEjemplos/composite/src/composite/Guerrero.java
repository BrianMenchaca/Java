package composite;

public class Guerrero extends Unidad {

	private int salud = 100;

	@Override
	public void atacar(Unidad otro) {
		if (this.estaVivo())
			otro.recibir(10);
	}

	@Override
	public void recibir(int danio) {
		if (this.estaVivo())
			this.salud -= danio;
	}

	@Override
	public String toString() {
		return "Guerrero [salud=" + salud + "]";
	}

	@Override
	public boolean estaVivo() {
		return this.salud > 0;
	}
}
