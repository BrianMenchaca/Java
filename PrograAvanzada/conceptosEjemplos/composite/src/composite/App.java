package composite;

public class App {

	public static void main(String[] args) {
		Tropa uno = new Tropa();
		uno.agregar(new Guerrero());
		uno.agregar(new Guerrero());
		uno.agregar(new Guerrero());
		
		Tropa dos = new Tropa();
		dos.agregar(new Guerrero());
		dos.agregar(new Guerrero());
		dos.agregar(new Guerrero());
		
		Tropa dosa = new Tropa();
		dosa.agregar(new Guerrero());
		dosa.agregar(new Guerrero());
		
		dos.agregar(dosa);
		
		for (int i = 0; i < 5; i++) {
			uno.atacar(dos);
		}
		
		System.out.println(uno);
		System.out.println(dos);
	}
}