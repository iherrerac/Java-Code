package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

/*
 * 3 Botones que cambian el color del fondo de la lamina
 * mediante una objeto Listener ColorFondo
 */

public class A07Botones2 {

	public static void main(String[] args) {
		Marcos7 M7 = new Marcos7();
		M7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Marcos7 extends JFrame{
	public Marcos7() {
		setVisible(true);
		setBounds(400,200,600,400);
		setTitle("Eventos");
		Lamina6 L6 = new Lamina6();
		add(L6);
	}
}

class Lamina7 extends JPanel{
	//instanciamos objeto JButton BotonColor
	JButton BotonColor = new JButton("Azul");
	JButton BotonColor1 = new JButton("Amarillo");
	JButton BotonColor2 = new JButton("Rojo");
	
	//Constructor
	public Lamina7() {
		//Agregamos el boton 
		add(BotonColor);
		add(BotonColor1);
		add(BotonColor2);
		//implementamos el metodo actionListenber e indicamos el listener en este caso la Clase Lamina6 mediante (this)
		//fuente.Evento(listener)
		BotonColor.addActionListener(new ColorFondo(Color.BLUE));
		BotonColor1.addActionListener(new ColorFondo(Color.YELLOW));
		BotonColor2.addActionListener(new ColorFondo(Color.RED));
	}
	
	/*
	 * Creamos un objeto Color fondo que es una clase interna para que pueda
	 * acceder almetodo setBackground de la lamina 
	 */
	
	private class ColorFondo implements ActionListener {
		
		public ColorFondo(Color c) {
		 colordeFondo =c;
		}
		
		public void actionPerformed(ActionEvent e) {
			//Object BotonPulsado = e.getSource();
			setBackground(colordeFondo);
		}
		private Color colordeFondo;
	}
}





















