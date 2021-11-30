package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Aplicacion que comprueba email cuando campo texto cuadro1 pierde el foco
 * el campo cuadro3 lo declaramos diferente inicializando la clase FocusAdapter directamente
 * en la declaracion
 */
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
		JTextField cuadro3 = new JTextField(); // No hace falta declararla fuera
		
		cuadro1.setBounds(30,40,100,20);
		cuadro2.setBounds(30,65,100,20);
		cuadro3.setBounds(30,90,100,20);
		
		LanzaFoco foco= new LanzaFoco();
		cuadro1.addFocusListener(foco);
		cuadro3.addFocusListener(new FocusAdapter() {//Declaramos directamente la clase adaptadora
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println("El cuadro3 ha ganado el foco");
			}
		});
		add(cuadro1);
		add(cuadro2);
		add(cuadro3);
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
			//Texto de cuadro a una variable
			String email = cuadro1.getText();
			boolean arroba= false;
			for ( int i=0; i< email.length();i++) {
				if(email.charAt(i) == '@') {
					arroba = true;
				}
			}
			
			if (arroba) {
				System.out.println("EMail Correcto");
			}else {
				System.out.println("Email incorrecto.");
			}
		
		}
	}
}
