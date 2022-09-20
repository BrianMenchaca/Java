package tierraDeFantasia;

public class Detonadora extends Raza{
	
	private int turnosBuff;
	
	public Detonadora() {
		this.salud = 93;
		this.dañoBasico = 72;
		this.turnosBuff = 0;
	}
	
	public int atacar(Raza enemigo) {
		if()
			
		vida += 3;
		return turnosBuff > 0? this.dañoBasico * 3 : this.dañoBasico;
	}
	
	public void descansar() {
		this.turnosBuff = 2;
	}
	
	public void recibirAtaque(int dañoRecibido) {
		this.salud -= dañoRecibido;
	}
	
	public void moverse() {
		
	}
}
