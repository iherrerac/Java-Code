package poo;

import javax.swing.Timer; //Lib Temporizador
import java.awt.event.*; // Lib Listener
import java.beans.ConstructorProperties;
import java.util.Date; // Hora
import javax.swing.JOptionPane;//Ventana
import java.awt.Toolkit; // sonido windows

public class Temporizador3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean sonido=true;
		int delay;
		String optSonido; 
		//Toma de opciones por pantalla
		delay = 1000*Integer.parseInt(JOptionPane.showInputDialog("Introduce delay: "));
		optSonido= JOptionPane.showInputDialog("Sonido? (Si/No)");
		
		if (optSonido.equalsIgnoreCase("si")) sonido=true; 
		else if (optSonido.equalsIgnoreCase("no")) sonido = false; 
		
		//Instanciamos Reloj y lo ponemos en marcha
		Reloj2 miReloj = new Reloj2(sonido, delay);
		miReloj.enMarcha();		
	}
}	

class Reloj2{
	
	//Constructor
	public Reloj2(boolean sonido, int delay){
		this.delay = delay;
		this.sonido = sonido;
	}
	
	public void enMarcha() {
		ActionListener Oyente = new Listener();
		Timer miTemp1 = new Timer(delay, Oyente);
		miTemp1.start();
		JOptionPane.showMessageDialog(null, "Pulsa para detener");
		System.exit(0);
	}
	private boolean sonido;
	private int delay;
	
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Date hora= new Date();
			System.out.println("Hora: "+hora);
			if(sonido) Toolkit.getDefaultToolkit().beep();
		}
	}
}

