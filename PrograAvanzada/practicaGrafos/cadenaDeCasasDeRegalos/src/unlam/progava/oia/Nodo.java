package unlam.progava.oia;

public class Nodo implements Comparable<Nodo>{

	private int gradoNodo;
	private int nodo;
	
	public Nodo(int nodo, int gradoNodo) {
		// TODO Auto-generated constructor stub
		this.nodo = nodo;
		this.gradoNodo = gradoNodo;
	}

	public int getGradoNodo() {
		return gradoNodo;
	}
	
	public void setGradoNodo(int gradoNodo) {
		this.gradoNodo = gradoNodo;
	}
	
	public int getNodo() {
		return nodo;
	}
	
	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	@Override
	public int compareTo(Nodo o) {
		// TODO Auto-generated method stub
		return o.gradoNodo - this.gradoNodo;
	}
}
