package patronState;

public class App {
	
	public static void main(String[] args) {
		Tanque t = new Tanque();
		t.moverse();
		t.atacar();
		
		t.cambiarModo();
		
		t.moverse();
		t.atacar();
		
		t.cambiarModo();
		
		t.moverse();
	}

}