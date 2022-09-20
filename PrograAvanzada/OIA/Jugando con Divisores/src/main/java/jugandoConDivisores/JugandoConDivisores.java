package jugandoConDivisores;

public class JugandoConDivisores {

	public static void programa(String inputFilePath, String outputFilePath) {

		try {
			int n = GestorDeArchivos.lecturaArchivo(inputFilePath);
			if(n < 1)
				throw new ExceptionMenorOIgualACero();
			GestorDeArchivos.grabarArchivo(outputFilePath, divisores(n));
		} catch(ExceptionMenorOIgualACero e) {
			e.printStackTrace();
			System.out.println("Error: Valor negativo o cero.");
		}
	}

	public static int[] divisores(int n) {
		int[] resultado = { primeroAgustin(n), primeroGaston(n) };

		return resultado;
	}

	public static int primeroAgustin(int numero) {

		int resultado = numero;
		while (numero > 1) {
			numero = numero / mayorPrimo(numero);
			resultado += numero;

			if (numero > 1) {
				numero = numero / menorPrimo(numero);
				resultado += numero;
			}
		}
		return resultado;
	}

	public static int primeroGaston(int numero) {

		int resultado = numero;
		while (numero > 1) {
			numero = numero / menorPrimo(numero);
			resultado += numero;

			if (numero > 1) {
				numero = numero / mayorPrimo(numero);
				resultado += numero;
			}
		}
		return resultado;
	}

	public static int mayorPrimo(int numero) {

		int i = numero / 2;
		int j = 2;

		while (i <= numero) {

			int count = 0;
			j = 2;

			while (j <= i && count < 2) {

				if (i % j == 0) {
					count++;
				}
				j++;
			}

			if (count == 1 && numero % i == 0)
				return i;
			i--;
		}
		return numero;
	}

	public static int menorPrimo(int numero) {

		int i = 2;
		int j = 2;

		while (i <= numero) {

			int count = 0;
			j = 2;

			while (j <= i && count < 2) {

				if (i % j == 0) {
					count++;
				}
				j++;
			}

			if (count == 1 && numero % i == 0)
				return i;
			i++;
		}
		return numero;
	}
}
