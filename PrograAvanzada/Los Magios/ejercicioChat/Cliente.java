package ejercicioChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente{

	private Socket socket;
	private String nombre;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private Scanner scan = new Scanner(System.in);
	
	public Cliente(String ip, Integer puerto) throws UnknownHostException, IOException {
		//Con el socket, inicia conexion con Server
		this.socket = new Socket(ip,puerto);
		entrada = new DataInputStream(socket.getInputStream());
		salida = new DataOutputStream(socket.getOutputStream());
		//Le obligo a que ingrese un nombre valido
		
		System.out.println("Ingrese su nombre -> ");
		String nombre = scan.nextLine();
		
		//Envio nombre al server
		salida.writeUTF(nombre);
		
		while(!entrada.readUTF().toLowerCase().equals("ok")) {
			System.out.println("Nombre ya existente. Ingrese otro nombre -> ");
			nombre = scan.nextLine();
		}
		
		System.out.println("Cliente conectado correctamete.");
		
	}
	
	public String getNombreCliente() {
		return nombre;
	}
	
	public void iniciarChatCliente() throws UnknownHostException, IOException, InterruptedException {
		// Enviar mensaje escrito por consola
		System.out.println("Escribir mensaje -> ");
		String mensajeConsola = scan.nextLine();
		
		salida.writeUTF(mensajeConsola);
		
		while(mensajeConsola.compareTo("/salir") != 0) {
			//Una vez que escribi, espero la respuesta del servidor y la muestro
			System.out.print(entrada.readUTF());
			//Sigue mandando mensajes hasta que salga con el comando
			mensajeConsola = scan.nextLine();
			salida.writeUTF(mensajeConsola);
		}
		
		System.out.println("Has salido del chat...");
		
		scan.close();
		entrada.close();
		salida.close();
		socket.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		try {
			Cliente nuevoCliente = new Cliente("localhost", 20000);
			nuevoCliente.iniciarChatCliente();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
