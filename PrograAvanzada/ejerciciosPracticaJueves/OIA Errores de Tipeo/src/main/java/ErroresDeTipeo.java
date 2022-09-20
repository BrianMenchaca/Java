
public class ErroresDeTipeo {

	public static int procesarTexto(char[] texto, char[] prueba) {
		int tamTexto = texto.length;
		int posicionLetraABuscar = 0;
		int cantPermutaciones = 0;
		while(posicionLetraABuscar < tamTexto) {
			char letraTexto = texto[posicionLetraABuscar];
			int indexPrueba = 0;
			
			while(prueba[indexPrueba + posicionLetraABuscar] != letraTexto) {
				indexPrueba++;
			}
			
			for(int i = 0; i < indexPrueba; i++) {
				char aux = prueba[indexPrueba + posicionLetraABuscar - i];
				prueba[indexPrueba + posicionLetraABuscar - i] = prueba[indexPrueba + posicionLetraABuscar - i - 1];
				prueba[indexPrueba + posicionLetraABuscar - i - 1] = aux;
				cantPermutaciones++;
			}
			
			posicionLetraABuscar++;
			System.out.println(prueba);
		}
		
		return cantPermutaciones;
	}
	
}