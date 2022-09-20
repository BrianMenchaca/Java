package sanandoLuchadores;

public class Sanador {

	public static int sanar(int magia, int[] vidaInicial, int[] vidaActual, int[] distancia)
			throws ExceptionDistintoLargo {

		int cantidadMaximaSanadoTotal = 0;
		try {
			int i = 0;
			
			int maxLuchadores = vidaActual.length;

			while (magia >= 3 && i < maxLuchadores) {
				System.out.println(vidaInicial[i] + " " + vidaActual[i] + " " + distancia[i]);
				if (distancia[i] <= 1 && vidaActual[i] < vidaInicial[i]) {
					vidaActual[i] += 10;
					magia -= 3;
					cantidadMaximaSanadoTotal += 10;

					if (vidaActual[i] > vidaInicial[i]) {
						cantidadMaximaSanadoTotal -= vidaActual[i] - vidaInicial[i];
						vidaActual[i] = vidaInicial[i];
					}
				}

				if (distancia[i] > 1 && distancia[i] <= 2 && vidaActual[i] < vidaInicial[i] && magia >= 5) {
					vidaActual[i] += 10;
					magia -= 5;
					cantidadMaximaSanadoTotal += 10;

					if (vidaActual[i] > vidaInicial[i]) {
						cantidadMaximaSanadoTotal -= vidaActual[i] - vidaInicial[i];
						vidaActual[i] = vidaInicial[i];
					}
				}

				i++;
			}
//		} catch (ExceptionDistintoLargo e) {
			// TODO: handle exception
//			e.printStackTrace();
		} finally {
		}

		return cantidadMaximaSanadoTotal;
	}
}
