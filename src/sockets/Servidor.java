package sockets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Sockets 
 * Video 190,191
 * Video 191: Creacion de Thread con una tarea que realiza en segundo plano que permanezca a la
 * escucha del puerto 9999 permanentemente.
 */
public class Servidor {

	public static void main(String[] args) {
		MarcoServidor miMarco= new MarcoServidor();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoServidor extends JFrame implements Runnable{
	public MarcoServidor() {
		setBounds(900,300,280,350);
		JPanel miLamina = new JPanel();
		miLamina.setLayout(new BorderLayout());
		areaTexto = new JTextArea();
		miLamina.add(areaTexto,BorderLayout.CENTER);
		add(miLamina);
		setVisible(true);
		// creamos hilo instanciando Thread. El parametro es el target ( el Marco)
		Thread miHilo= new Thread (this);
		miHilo.start();
	}
	
	private JTextArea areaTexto;

	@Override
	public void run() {
		System.out.println("A la escucha");
		//Server socket argumento de tipo entero especificando que tiene que abrir
		try {
			ServerSocket servidor = new ServerSocket(9999);
			//Permanezca a la escucha del puerto y acepte las peticiones
			while(true) {//Bucle infinito en segundo plano para que siempre este a la escucha
			Socket miSocket = servidor.accept();
			//Creamos el flujo de entrada
			DataInputStream flujo_entrada= new DataInputStream(miSocket.getInputStream());
			String mensajeTexto= flujo_entrada.readUTF();
			areaTexto.append("\n"+mensajeTexto);
			miSocket.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
