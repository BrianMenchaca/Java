package ejercicio02Revision1;

public class Jinete {
	
	public static int jinetes(int[]estaciones) {
		//No contempla que haya más de 100 millas de distancia entre estaciones
		int jinetesNecesarios = 1;
		int kilometros = 0;
		
		for (int i : estaciones) {
			if(kilometros + i <= 100) {
				kilometros += i;
			} else {
				kilometros = i;
				jinetesNecesarios++;
			}
		}
		
		return estaciones.length == 0 ? 0 : jinetesNecesarios;
	}
	
	public static void main(String[] args) {
		System.out.println(jinetes(new int[] {18, 15}));
		System.out.println(jinetes(new int[] {43, 23, 40, 13}));
		System.out.println(jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
		System.out.println(jinetes(new int[] {51, 51, 51}));
		System.out.println(jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
		System.out.println(jinetes(new int[] {10, 10, 10, 10, 10, 10, 10}));
		System.out.println(jinetes(new int[] {100}));
		System.out.println(jinetes(new int[] {}));
	}
}
