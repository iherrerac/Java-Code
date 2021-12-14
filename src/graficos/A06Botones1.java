package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

/*
 * 3 Botones que cambian el color del fondo de la lamina
 * implementando la interfaz ActionListener en la Lamina
 */

public class A06Botones1 {

	public static void main(String[] args) {
		Marcos6 M6 = new Marcos6();
		M6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Marcos6 extends JFrame{
	public Marcos6() {
		setVisible(true);
		setBounds(400,200,600,400);
		setTitle("Eventos");
		Lamina7 L6 = new Lamina7();
		add(L6);
	}
}

class Lamina6 extends JPanel implements ActionListener{
	//instanciamos objeto JButton BotonColor
	JButton BotonColor = new JButton("Azul");
	JButton BotonColor1 = new JButton("Amarillo");
	JButton BotonColor2 = new JButton("Rojo");
	
	//Constructor
	public Lamina6() {
		//Agregamos el boton 
		add(BotonColor);
		add(BotonColor1);
		add(BotonColor2);
		//implementamos el metodo actionListenber e indicamos el listener en este caso la Clase Lamina6 mediante (this)
		//fuente.Evento(listener)
		BotonColor.addActionListener(this);
		BotonColor1.addActionListener(this);
		BotonColor2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		//Declaramos una variable de tipoobjeto y llamamos al metodo getsource de la clase ActionEvent nos indica quien es la fuente el origen del evento
		Object BotonPulsado=e.getSource();
		if (BotonPulsado==BotonColor) {
			setBackground(Color.BLUE);
		} else if (BotonPulsado==BotonColor1){
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.RED);
		}

	}
}




















