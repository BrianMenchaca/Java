package source;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PilasDeMesadas {
	List<Mesada> mesadas;

	public PilasDeMesadas(List<Mesada> mesadas) {
		super();
		this.mesadas = mesadas;
	}

	public int resolver() {
		Collections.sort(this.mesadas);
		Iterator<Mesada> iterator = mesadas.iterator();
		Mesada mesada = iterator.next();
		int cantPilas = 1;
		Mesada nuevaMesada;
		while (iterator.hasNext()) {
			nuevaMesada = iterator.next();
			if (!mesada.sePuedeApilar(nuevaMesada)) {
				mesada = nuevaMesada;
				cantPilas++;
			}
		}
		return cantPilas;
	}

	public void mostrarMesadas() {
		for (Mesada mesada : this.mesadas) {
			System.out.println(mesada);
		}
	}
}
