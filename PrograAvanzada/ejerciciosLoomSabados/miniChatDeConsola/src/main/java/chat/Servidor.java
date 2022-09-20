package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	private boolean isClosed = false;
	private ArrayList<Socket> sockets;
	private ServerSocket servidor;
	private ArrayList<Mensaje> mensajes;
	private static int tamSala = 5;

	public Servidor(int puerto) throws IOException {
		servidor = new ServerSocket(puerto);
		sockets = new ArrayList<Socket>();

		System.out.println("Server inicializando...");
	}

	/// Metodo Aceptar Cliente
	public void aceptarCliente() throws IOException, InterruptedException {

		Socket socket = servidor.accept();
		sockets.add(socket);
		DataInputStream entrada = new DataInputStream(socket.getInputStream());

		String mensaje = entrada.readUTF();
		String nick = mensaje;
		System.out.println(nick + " ha entrado a la sala.");

		try {
			while (mensaje != "/salir") {
				mensaje = entrada.readUTF();
				System.out.println(nick + ": " + mensaje);
			}
		} catch (IOException e) {
			System.out.println(nick + " se ha desconectado");
		}

		entrada.close();
		socket.close();
	}

	/// Metodo Recibir mensaje
//	public void recibirMensajes ()

	public static void main(String[] args) {
		try {
			final Servidor servidor = new Servidor(20000);

			for (int i = 0; i < 5; i++) {
				Thread t1 = new Thread() {
					@Override
					public void run() {
						try {
							servidor.aceptarCliente();
						} catch (IOException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				t1.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
