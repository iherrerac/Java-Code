package sockets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;

/*
 * Video 190,191,192,193,194,195,196,197,198,199,200
 * Sockets
 * Aplicacion chat cliente servidor . Para crear el socket necesitamos ip y el puerto
 * Video 191: Creacion de flujo de salida, 
 * Video 192: Aplicacion con multiples clientes
 * Video 193: Aplicacion con multiples clientes II. ObjectOutputStream
 * Video 196: nick como JLabel en vez de JTextPanel e Ip como JCombobox
 * Video 197: Enviar señal al servidor para indicar que esta online. Creamos una clase en el cliente
 * EnvioOnline para que envia una señal, y en el servidor para que la reciba
 * Video 198: Incluimos en servidor un if else para que detecte si es el primer mensaje que envia o no
 * Video 199: ArrayList con todas las ips que se conecten. Modificamos PaqueteEnvio agregando
 * que envie el ArrayList.
 * Video 200
 */

public class Cliente {

	public static void main(String[] args) {
		MarcoCliente miMarco= new MarcoCliente();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCliente extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarcoCliente() {
		setBounds(600,300,280,350);
		LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
		add(miLamina);
		setVisible(true);
		addWindowListener(new EnvioOnline());
	}
}

//Clase para enviar señal online automaticamente al abrir la aplicacion
class EnvioOnline extends WindowAdapter{
	public void windowOpened(WindowEvent e) {
		try {
			Socket miSocket = new Socket ("192.168.0.26",9999);
			PaqueteEnvio datos = new PaqueteEnvio();
			datos.setMensaje(" online");
			ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
			paqueteDatos.writeObject(datos);
			miSocket.close();
		}catch (Exception e2) {
			
		}
		
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LaminaMarcoCliente() {
		String nickUsuario = JOptionPane.showInputDialog("Nick: ");
		JLabel nNick = new JLabel("Nick: ");
		add(nNick);
		nick = new JLabel(nickUsuario);
		add(nick);
		JLabel texto = new JLabel("- Online: ");
		add(texto);
		ip =  new JComboBox();
		//ip.addItem("Usuario 1");
		//ip.addItem("Usuario 2");
		//ip.addItem("Usuario 3");
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
				datos.setIp(ip.getSelectedItem().toString());//Cual es el componente seleccionado en el comboBox
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
				if(!paqueteRecibido.getMensaje().equals(" online")) {
					campoChat.append("\n"+paqueteRecibido.getNick()+": "+ paqueteRecibido.getMensaje());
				}else {
					ip.removeAllItems();
					for (String s: paqueteRecibido.getIps())
					ip.addItem(s);
					campoChat.append("\n"+paqueteRecibido.getIps());   
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	private JTextArea campoChat;
	private JButton miBoton;
}

class PaqueteEnvio implements Serializable{ // Hay que serializar la clase para que pueda convertirse en datos
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}
	private String nick, ip, mensaje;
	private ArrayList <String> ips;
	
}