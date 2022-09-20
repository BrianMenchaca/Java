package tierraDeFantasia;

public class Posicion {
	double x;
	double y;
	
	public Posicion(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getDistancia(Posicion p)
	{
		double distancia = 0;
		distancia = Math.sqrt( Math.pow(p.x - x,2) + Math.pow(p.y - y,2));
		return distancia;
	}
}
