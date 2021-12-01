package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

/*
 * 2 Paneles, uno BorderLayout y otro FlowLayout
 */

public class Layouts3 {

	public static void main(String[] args) {
		MiMarco17 M17 = new MiMarco17();
		M17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco17 extends JFrame{
	
	public MiMarco17() {
		setVisible(true);
		setBounds(600,350,600,300);
		//En el constructor del Marco indicamos la posicion de cada Layout al agregarlo
		MPanel17 P17= new MPanel17();
		MPanel18 P18= new MPanel18();
		add(P17,BorderLayout.NORTH);
		add(P18,BorderLayout.SOUTH);
	}
	
}

//Lamina1
class MPanel17 extends JPanel{
	public MPanel17() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new JButton("Primer Layout"));

	}
}

//Lamina2
class MPanel18 extends JPanel{
	public MPanel18() {
		setLayout(new BorderLayout(10,10));
		add(new JButton("Segundo Layout"),BorderLayout.NORTH);
		add(new JButton("Rojo"),BorderLayout.WEST);
		add(new JButton("Azul"),BorderLayout.SOUTH);
		add(new JButton("Rosa"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);
	}
}
