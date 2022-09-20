package chat;

import java.awt.Font;

public class Mensaje {

	private Font font;
	private String mensaje;
	private String nick;
	
	public Mensaje(Font font, String mensaje, String nick) {
		this.font = font;
		this.mensaje = mensaje;
		this.nick = nick;
	}
	
	public Font getFont() {
		return font;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
}
