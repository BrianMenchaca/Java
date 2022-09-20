package ejercicioChat;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
		
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Ingrese texto: ");
    	String palabra = scan.nextLine();
    	
    	System.out.println("Palabra escrita: <"+palabra+">");
    	
    	scan.close();
	}
}
