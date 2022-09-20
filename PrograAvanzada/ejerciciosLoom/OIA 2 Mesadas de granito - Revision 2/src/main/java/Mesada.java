
public class Mesada implements Comparable<Mesada> {
	private int largo;
	private int ancho;

	public Mesada(int largo, int ancho) {
		super();
		this.largo = largo;
		this.ancho = ancho;
	}

	public boolean sePuedeApilar(Mesada m) {
		return this.getMaxDimension() >= m.getMaxDimension() && this.getMinDimension() >= m.getMinDimension();
	}

	private int getMaxDimension() {
		return this.largo > this.ancho ? this.largo : this.ancho;
	}

	private int getMinDimension() {
		return this.largo < this.ancho ? this.largo : this.ancho;
	}

	public int compareTo(Mesada o) {
		int diff = o.getMaxDimension() - this.getMaxDimension();
		if (diff == 0)
			return o.getMinDimension() - this.getMinDimension();
		return diff;
	}

	@Override
	public String toString() {
		return "Mesada [largo=" + largo + ", ancho=" + ancho + "]";
	}

}
