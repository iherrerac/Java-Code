package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

/*
 * BorderLayout
 */

public class Layouts2 {

	public static void main(String[] args) {
		MiMarco16 M16 = new MiMarco16();
		M16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco16 extends JFrame{
	
	public MiMarco16() {
		setVisible(true);
		setBounds(600,350,600,300);
		MPanel16 P16= new MPanel16();
		add(P16);
	}
	
}

class MPanel16 extends JPanel{
	public MPanel16() {
		/*
		 * Por comodidas se acostumbra a indicar el layout y los elementos en el mismo constructor
		 * En este caso en el panel. Instanciamos directamente en una setlayout
		 */
		/*
		 * Rellena toda la zona si no indicamos nada en el constructor de BorderLayout
		 * Podemos indicar separacion x,y 
		 */
		setLayout(new BorderLayout(10,10));
		add(new JButton("Amarillo"),BorderLayout.NORTH);
		add(new JButton("Rojo"),BorderLayout.WEST);
		add(new JButton("Azul"),BorderLayout.SOUTH);
		add(new JButton("Rosa"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);
	}
}


