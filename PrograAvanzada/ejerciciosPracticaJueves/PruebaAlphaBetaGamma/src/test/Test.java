package test;


public class Test {

	public static void main(String[] args) {
//		Gamma g1 = new Alpha();
//
//        Gamma g2 = new Beta();

//        System.out.println(g1.getType() + " " + g2.getType());
        
        Alpha a = new Beta();
        Beta b = new Beta();
        
        System.out.println(((Beta)a).message());
        
        System.out.println(a.response());
        
//        System.out.println(b.incrementarValor(50));
        
        try {
			b.incrementarValor(50);
		}
        catch (ExceptionPrueba e) {
			// TODO Auto-generated catch block
			System.out.println("hubo una excepcion!");
		}
	}
	
}
