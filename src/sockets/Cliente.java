package sockets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Video 190,191,192,193,194,195; 
 * Sockets
 * Aplicacion chat cliente servidor . Para crear el socket necesitamos ip y el puerto
 * Video 191: Creacion de flujo de salida, 
 * Video 192: Aplicacion con multiples clientes
 * Video 193: Aplicacion con multiples clientes II. ObjectOutputStream
 */

public class Cliente {

	public static void main(String[] args) {
		MarcoCliente miMarco= new MarcoCliente();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCliente extends JFrame{
	public MarcoCliente() {
		setBounds(600,300,280,350);
		LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
		add(miLamina);
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	public LaminaMarcoCliente() {
		nick = new JTextField(5);
		add(nick);
		JLabel texto = new JLabel("- CHAT -");
		add(texto);
		ip =  new JTextField(8);
		add(ip);
		campoChat = new JTextArea(12,20);
		add(campoChat);
		campo1 = new JTextField(20);
		add(campo1);
		miBoton= new JButton("Enviar");
		EnviaTexto miEvento= new EnviaTexto();
		miBoton.addActionListener(miEvento);
		add(miBoton);
		//Cuando la aplicacion se ejecuta es en la propia lamina en el constructor ponemos en funcionamiento el hilo
		//Es la propia clase donde nos encontramos la que tiene este hilo/metodo run, por eso this
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(campo1.getText());// imprime el texto del JTextField
			campoChat.append("\nYo: "+campo1.getText());
			try {
				//Comunicar con el servidor
				Socket miSocket = new Socket("192.168.0.26",9999);
				//Video 192 enviamos nick, ip y mensaje.Empaquetamos datos
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp(ip.getText());
				datos.setMensaje(campo1.getText());
				
				//Ya no enviamos texto si no un objeto:
				ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());
				paquete_datos.writeObject(datos);
				miSocket.close();
//				//Video 191 Solo envia el campo de JTextArea				
//				//Flujo de datos de salida que circula por el socket creado
//				DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
//				//Escribe en el flujo lo que hay en el campo1, el flujo circulara por el socket 
//				//y se dirige al servidor indicado
//				flujo_salida.writeUTF(campo1.getText());
//				flujo_salida.close();//Cierramos flujo
			} catch (IOException e1) {
				System.out.println(e1.getMessage());// Cual ha sido el error?
			}
		}
		
	}
	
	@Override
	public void run() {
		try {
			ServerSocket servidor_cliente = new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
			cliente= servidor_cliente.accept();
			ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
			paqueteRecibido = (PaqueteEnvio)flujoEntrada.readObject();
			campoChat.append("\n"+paqueteRecibido.getNick()+": "+ paqueteRecibido.getMensaje());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private JTextField campo1, nick, ip;
	private JTextArea campoChat;
	private JButton miBoton;
}

class PaqueteEnvio implements Serializable{ // Hay que serializar la clase para que pueda convertirse en datos
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	private String nick, ip, mensaje;
}