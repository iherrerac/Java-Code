package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosDeFoco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco11 M11 = new MiMarco11();
		M11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco11 extends JFrame{
	public MiMarco11(){
		setVisible(true);
		setBounds(400,200,600,400);
		add(new MiPanel11());
	}
}

class MiPanel11 extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Anulamos el layout por defecto ( Disposicion de los elementos )
		setLayout(null);
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		cuadro1.setBounds(30,40,100,20);
		cuadro2.setBounds(30,65,100,20);
		LanzaFoco foco= new LanzaFoco();
		cuadro1.addFocusListener(foco);
		add(cuadro1);
		add(cuadro2);
	}
	// Declaramos fuera para poder acceder a los campos
	JTextField cuadro1;
	JTextField cuadro2;
	
	//Subclase para poder acceder a los campos desde la subclase
	private class LanzaFoco implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			System.out.println("He Perdido el Foco.");
		}
		
	}
}

