package servidor_hilos;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HiloDistribuirMensaje extends Thread {
	private Socket cliente;
	private ArrayList<String> mensajes;
	private ArrayList<Socket> clientes;
	private String nombreCliente;
	private HashSet<String> nombresUsuarios;
	PrintWriter out;
	Scanner in;

	public HiloDistribuirMensaje(Socket cliente, ArrayList<Socket> clientes, HashSet<String> nombresUsuario, ArrayList<String> mensajes) {
		this.cliente = cliente;
		this.clientes = clientes;
		this.nombresUsuarios = nombresUsuario;
		this.mensajes = mensajes;

		try {
			out = new PrintWriter(cliente.getOutputStream(), true);
			in = new Scanner(cliente.getInputStream());
		} catch (IOException e) {
			System.out.println("Error al conectarse con la entrada/salida del cliente: " + e);
		}
	}

	@Override
	public void run() {
		String nombreUsuario = null;

		while (true) {
			out.println("/INGRESE NOMBRE");
			nombreUsuario = in.nextLine();

			if (!nombresUsuarios.contains(nombreUsuario.toLowerCase())) {
				nombresUsuarios.add(nombreUsuario.toLowerCase());
				break;
			}
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		distribuirMensaje(dtf.format(LocalDateTime.now())+"|  "+ nombreUsuario + " ha ingresado al chat.");
		distribuirMensajesHistoricos(mensajes);
		
		while (!cliente.isClosed()) {
			String mensaje = null;

			try {
				// lee el input del cliente 
				mensaje = in.nextLine();

				// si se envia /salir, manda a cerrar el cliente y avisa al servidor de que se fue(y se informa al resto)
				if (mensaje.toLowerCase().contains("/salir")) {
					System.out.println(nombreUsuario + " ha salido.");
					distribuirMensaje(dtf.format(LocalDateTime.now())+" " + nombreUsuario + " ha salido del chat.");

					clientes.remove(cliente);
					nombresUsuarios.remove(nombreUsuario.toLowerCase());//quito el cliente que se fue

					out.println("/salir");

					return;
				}
				
				mensajes.add(mensaje);
				// envio el mensaje al resto de clientes
				distribuirMensaje(mensaje);
			} catch (NoSuchElementException e) {
				System.out.println(nombreCliente + " ha salido.");
			}
		}
	}

	private void distribuirMensaje(String mensaje) {
		PrintWriter output;
		for (Socket cliente : clientes) {
			if (cliente != this.cliente) {
				try {
					output = new PrintWriter(cliente.getOutputStream(), true);
					output.println(mensaje);
				} catch (IOException e) {
					System.out.println("Problema al mandar mensajes: " + e);
				}
			}
		}
	}

	private void distribuirMensajesHistoricos(ArrayList<String> mensajes) {
		PrintWriter output;
		for (String mensaje : mensajes) {
				try {
					output = new PrintWriter(this.cliente.getOutputStream(), true);
					output.println(mensaje);
				} catch (IOException e) {
					System.out.println("Problema al mandar mensajes: " + e);
				}
		}
	}
}
