package decorator;

public class App {

	public static void main(String[] args) {
		Unidad pj = new Personaje();
		System.out.println(pj.getDanio());
		
		pj = new ConAmuleto(pj);
		System.out.println(pj.getDanio());
		
		pj = new ConEspada(pj);
		System.out.println(pj.getDanio());
		
		pj = new ConAmuleto(pj);
		System.out.println(pj.getDanio());
		
	}

}