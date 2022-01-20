package sockets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * Sockets 
 * Video 190,191,193,194,195,196,197,198,199,200
 * Video 191: Creacion de Thread con una tarea que realiza en segundo plano que permanezca a la
 * escucha del puerto 9999 permanentemente.
 * Video 193: Aplicacion multicliente. Recibimos datos com oobeto
 * Video 196: nick como JLabel en vez de JTextPanel e Ip como JCombobox en cliente
 * Video 197: Enviar señal al servidor para indicar que esta online. Creamos una clase en el cliente
 * EnvioOnline para que envia una señal, y en el servidor para que la reciba
 * Video 198: Incluimos en servidor un if else para que detecte si es el primer mensaje que envia o no
 * Video 199: ArrayList con todas las ips que se conecten. Modificamos PaqueteEnvio agregando
 * que envie el ArrayList
 * Video 200:
 */
public class Servidor {

	public static void main(String[] args) {
		MarcoServidor miMarco= new MarcoServidor();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoServidor extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			//Video 193: para recibir objetos
			String nick,ip,mensaje;
			PaqueteEnvio paquete_recibido;
			ArrayList <String> listaIp= new ArrayList<String>();
			//Permanezca a la escucha del puerto y acepte las peticiones
			while(true) {//Bucle infinito en segundo plano para que siempre este a la escucha
			Socket miSocket = servidor.accept();
			ObjectInputStream paquete_datos = new ObjectInputStream(miSocket.getInputStream());
			paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();
			nick = paquete_recibido.getNick();
			ip = paquete_recibido.getIp();
			mensaje = paquete_recibido.getMensaje();
			
			if(!mensaje.equals(" online")) {//Ya se conecto por primera vez
			areaTexto.append("\n" + nick + " : "+ mensaje + " para " + ip);
			Socket enviaDestinatario = new Socket(ip,9090);
			ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
			paqueteReenvio.writeObject(paqueteReenvio);
			paqueteReenvio.close();
			enviaDestinatario.close();
			}else {
				//Online (Video 197)
				String IpRemota = miSocket.getInetAddress().getHostAddress();
				System.out.println("Online: "+ IpRemota);
				listaIp.add(IpRemota);
				paquete_recibido.setIps(listaIp);
				for (String z: listaIp) {
					System.out.println("Array: "+z);
					Socket enviaIps = new Socket(z,9090);
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaIps.getOutputStream());				
					paqueteReenvio.writeObject(paqueteReenvio);
					paqueteReenvio.close();
					enviaIps.close();
					//miSocket.close();
				}
				//-----

			}
//			//Video 191: Recibimos JTextArea del cliente
//			//Creamos el flujo de entrada
//			DataInputStream flujo_entrada= new DataInputStream(miSocket.getInputStream());
//			String mensajeTexto= flujo_entrada.readUTF();
//			areaTexto.append("\n"+mensajeTexto);
			miSocket.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
