package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// Importante: Checkear enconding -> UTF8

public class Cliente {
	private String nick;
	private String mensaje;

	public Cliente(String ip, int puerto) throws UnknownHostException, IOException, InterruptedException {
		// Conecta a un Server. Si no esta activo da Exception:
		// java.net.ConnectException
		System.out.println("Ingresar un nick:");
		final Scanner scanner = new Scanner(System.in);
		
		nick = scanner.nextLine();
		mensaje = nick;
		
		Socket socket = new Socket(ip, puerto);

		// Flujos de informaciÃ³n
		final DataInputStream entrada = new DataInputStream(socket.getInputStream());
		final DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

//		salida.writeUTF(nick);
		
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("hilo 1");
				
				try {
//					wait();
					mensaje = entrada.readUTF();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(mensaje);
			}
		};
		
		// Enviar mensaje escrito por consola
		
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("hilo 2");
				while(mensaje != "/salir") {
					try {
						salida.writeUTF(mensaje);
						mensaje = scanner.nextLine();
						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Se ha perdido la conexion.");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		// Cierre de recursos
		scanner.close();
		entrada.close();
		salida.close();
		socket.close();
		System.out.println("Me cierro");
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			new Cliente("localhost", 20000);
		} catch (IOException e) {
			System.out.println("Se ha perdido la conexion.");
		}
	}

}
