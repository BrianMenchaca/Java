package ejercicio02Revision2;

public class Jinete {
	public static int jinetes(int[] estaciones) {

		int cantidadMillas = 0, cantidadJinetes = 0;

		for (int i = 0; i < estaciones.length; i++) {

			cantidadMillas += estaciones[i];

			// Si la cantidad de Millas entre lo que tengo acumulado más la distancia con la
			// próxima parada
			// es mayor a 100, sumo un Jinete y pongo la cantidad de millas en cero.

			if (i < estaciones.length - 1 && cantidadMillas + estaciones[i + 1] > 100) {
				cantidadJinetes++;
				cantidadMillas = 0;
			}
		}

		cantidadJinetes++;

		return cantidadJinetes;
	}
}
