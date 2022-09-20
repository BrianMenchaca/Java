package tierraDeFantasia;

public abstract class Raza extends Partida{

	protected int salud;
	protected int rangoAtaque;
	protected int dañoBasico;
	protected Posicion posicionActual;
	
	public abstract void atacar();
	public abstract void descansar();
	public abstract void recibirAtaque();
	public abstract void moverse();
}
