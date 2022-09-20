package ejercicio02;

public class Ejercicio02 {

	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 *          extremo hasta el otro del recorrido
	 */
	public static int jinetes(int[] estaciones) {

		int cantidadJinetes = 0;
		int distanciaRecorrida = 0;

		for (int distancia : estaciones) {

			if (distanciaRecorrida + distancia <= 100) {

				distanciaRecorrida += distancia;
			} else {

				cantidadJinetes++;
				distanciaRecorrida = distancia;
			}
		}

		if (distanciaRecorrida > 0) {

			cantidadJinetes++;
		}

		return cantidadJinetes;
	}

}
