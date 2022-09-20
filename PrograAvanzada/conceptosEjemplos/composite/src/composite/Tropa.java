package composite;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Tropa extends Unidad {

	private List<Unidad> formacion = new LinkedList<Unidad>();
	
	public boolean agregar(Unidad unidad) {
		return this.formacion.add(unidad);
	}

	@Override
	public void atacar(Unidad otro) {
		if (this.estaVivo())
			for (Unidad unidad : formacion)
				unidad.atacar(otro);
	}

	@Override
	public void recibir(int danio) {
		if (this.estaVivo()) {
			Random rand = new Random();
			Unidad victima = this.formacion
	        	.get(rand.nextInt(this.formacion.size()));
			victima.recibir(danio);
			if (!victima.estaVivo())
				this.formacion.remove(victima);
		}
	}

	@Override
	public String toString() {
		return this.formacion.toString();
	}

	@Override
	public boolean estaVivo() {
		for (Unidad unidad : formacion) {
			if (unidad.estaVivo())
				return true;
		}
		return false;
	}	
}
