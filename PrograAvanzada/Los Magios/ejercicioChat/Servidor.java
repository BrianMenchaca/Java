package ejercicioChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Servidor {

	private int puerto;
	private ServerSocket server;
	private Set<String> clientes;
	private Chat chat;
	
	public Servidor(int puerto) throws IOException {
		this.puerto = puerto;
		server = new ServerSocket(puerto);
		clientes = new TreeSet<>();
		chat = null;
		System.out.println("Server inicializado...");
	}
	
	public void iniciarServer() throws IOException, InterruptedException {
		//La unica manera de cerrar el chat es saliendo
		Socket socket = null;
		DataOutputStream salida = null;
		DataInputStream entrada = null;
		
		try {
			while(true) {
				
				String nombreCliente = "";
				boolean existeCliente = true;
				
				//Empiezo con la escucha de clientes
				socket = server.accept();
				// Flujos de información
				salida = new DataOutputStream(socket.getOutputStream());
				entrada = new DataInputStream(socket.getInputStream());
				//Creo un nuevo thread por cada cliente que entra
				//Escucho nuevo nombre de cliente y chequeo si existe o no
				while(existeCliente && !nombreCliente.equals("/salir")) {
					nombreCliente = entrada.readUTF();
					existeCliente = clientes.contains(nombreCliente);
					//Le hago saber la respuesta al cliente
					salida.writeUTF( existeCliente? "no ok" : "ok");	
				}
				
				if(!nombreCliente.equals("/salir")) {
					//Inicia chat
					System.out.println("<"+nombreCliente+"> ha ingresado al chat.");
					chat = new Chat(nombreCliente, entrada, salida);
					//Arranca el chat
					Thread threadChat = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								chat.iniciarChat();
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					
					threadChat.start();
					//Termina el chat
					//chat.join();
				}
				
				//System.out.println("Ha salido un usuario");
				//Finaliza chat
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			// Se cierran recursos
			entrada.close();
			salida.close();
			socket.close();
		}
		
	}
	
	public void cerrarServer() throws IOException {
		server.close();
	}
	
	public static class Chat {
		List<String> mensajes;
		private String admin;
		private DataOutputStream salida;
		private DataInputStream entrada;
		private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
		private int indexLastMessage = 0;
		
		public Chat(String nombreAdmin, DataInputStream entrada, DataOutputStream salida) {
			admin = nombreAdmin;
			this.entrada = entrada;
			this.salida = salida;
			mensajes = new ArrayList<>();
		}
		
		/*@Override
		public void run() {
			try {
				iniciarChat();
				//Cerrar recursos cuando finaliza el chat
				entrada.close();
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/

		public synchronized void iniciarChat() throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			String mensajeCliente = entrada.readUTF();
			boolean sePuedeEscribir = true;
			
			while(!mensajeCliente.equals("/salir")) {
				
				while(!sePuedeEscribir) {
					wait();
				}
				//Bloqueo para utilizar la lista de mensajes
				sePuedeEscribir = false;
				//Obtener mensajes nuevos
				String nuevos = obtenerMensajesNuevos();
				
				if(!mensajeCliente.equals("")) {
					//Obtener fecha y hora
					String fechaHora = dtf.format(LocalDateTime.now());
					String nuevoMensaje = "<"+admin+">["+fechaHora+"]: " + mensajeCliente + "\n";
					
					System.out.print(nuevoMensaje);//Muestro nuevo mensaje en pantalla de servidor
					nuevos+=nuevoMensaje;
					mensajes.add(nuevoMensaje.replace("\n", ""));
					
				}
				
				//Enviar nuevos mensajes al cliente
				indexLastMessage = mensajes.size();
				salida.writeUTF(nuevos);
				sePuedeEscribir = true;
				notify();
				//Ahora espero por su nuevo mensaje
				mensajeCliente = entrada.readUTF();
			}
			//Salio del chat
			System.out.println("<"+this.admin+"> ha salido del chat");
		}

		private synchronized String obtenerMensajesNuevos() {
			// TODO Auto-generated method stub
			String nuevosMensajes = "";
			
			//Le sumo 1 para que no lea su ultimo mensaje
			for(int i=indexLastMessage + 1; i < mensajes.size(); i++) {
				nuevosMensajes += mensajes.get(i);
				nuevosMensajes += "\n";
			}
			
			return nuevosMensajes;
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		try {
			Servidor server = new Servidor(20000);
			server.iniciarServer();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
