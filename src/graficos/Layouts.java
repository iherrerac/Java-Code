package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;


/*
 * FlowLayout
 */

public class Layouts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco15 M15 = new MiMarco15();
		M15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco15 extends JFrame{
	
	public MiMarco15() {
		setVisible(true);
		setBounds(600,350,600,300);
		MPanel15 P15= new MPanel15();
		/*
		 * Indicamos al Layout que se alinee a la izquierda, asi como la separacion de los
		 * elementos en la lamina y lo seteamos en el panel. El constructor podemos establecer
		 * el alineamiento mediante una constante de la clase FlowLayout, y separacion X,Y
		 */
	
		FlowLayout Disposicion = new FlowLayout(FlowLayout.LEFT,20,150);
		P15.setLayout(Disposicion);
		
		add(P15);
	}
	
}

class MPanel15 extends JPanel{
	public MPanel15() {

		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		add(new JButton("Azul"));
	}
}

