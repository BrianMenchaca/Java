package servidor_hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import servidor_hilos.HiloDistribuirMensaje;

public class Servidor {
	private static ArrayList<Socket> clientes = new ArrayList<Socket>();
	private HashSet<String> nombresUsuario = new HashSet<String>();
	private ArrayList<String> mensajes = new ArrayList<String>();

	public Servidor(int puerto) {
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);

			System.out.println("Servidor levantado en el puerto: " + puerto);
			
			for (int i = 0; i < 10000; i++) {// hay que pasarlo al while para no tener
				// limites
				// int i = 0;
				// while (true) {
				Socket clienteSocket = null;
				try {
					clienteSocket = servidor.accept();
					System.out.println("Se ha conectado en cliente nro " + i + " exitosamente");
					clientes.add(clienteSocket);

					// se crean los hilos para los clientes, para enviar y distribuir los mensajes
					HiloDistribuirMensaje hiloCliente = new HiloDistribuirMensaje(clienteSocket, clientes,
							nombresUsuario, mensajes);
					hiloCliente.start();
					//i++;
				} catch (IOException e) {
					System.out.println("Error en la conexión con el cliente nro " + i + ": " + e);
				}
			}

			cerrarClientes();
			servidor.close();
			System.out.println("Server cerrado.");
		} catch (IOException e) {
			System.out.println("Error en la creación del servidor: " + e);
		}

	}

	private void cerrarClientes() {
		for (Socket cliente : clientes) {
			try {
				cliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int puerto = 9000;
		@SuppressWarnings("unused")
		Servidor server = new Servidor(puerto);
	}
}
