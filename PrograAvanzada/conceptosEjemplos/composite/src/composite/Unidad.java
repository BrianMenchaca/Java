package composite;

public abstract class Unidad {
	public abstract void atacar(Unidad otro);
	public abstract void recibir(int danio);
	public abstract boolean estaVivo();
}
