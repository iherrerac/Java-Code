package sockets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * Video 190,191: 
 * Sockets
 * Aplicacion chat cliente servidor . Para crear el socket necesitamos ip y el puerto
 * Video 191: Creacion de flujo de salida, 
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

class LaminaMarcoCliente extends JPanel{
	public LaminaMarcoCliente() {
		JLabel texto = new JLabel("CLIENTE");
		add(texto);
		campo1 = new JTextField(20);
		add(campo1);
		miBoton= new JButton("Enviar");
		EnviaTexto miEvento= new EnviaTexto();
		miBoton.addActionListener(miEvento);
		add(miBoton);
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(campo1.getText());// imprime el texto del JTextField
			try {
				//Comunicar con el servidor
				Socket miSocket = new Socket("192.168.0.26",9999);
				//Flujo de datos de salida que circula por el socket creado
				DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
				//Escribe en el flujo lo que hay en el campo1, el flujo circulara por el socket 
				//y se dirige al servidor indicado
				flujo_salida.writeUTF(campo1.getText());
				flujo_salida.close();//Cierramos flujo
			} catch (IOException e1) {
				System.out.println(e1.getMessage());// Cual ha sido el error?
			}
		}
		
	}
	
	private JTextField campo1;
	private JButton miBoton;
}