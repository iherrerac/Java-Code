package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;


public class CamposDeTexto {

	public static void main(String[] args) {
		MiMarco19 m18 = new MiMarco19 ();
		m18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MiMarco19 extends JFrame{
	public MiMarco19 () {
		add(new MPanel19());
		setTitle("Campos de Texto");
		setBounds(600,300,600,350);
		setVisible(true);
		
	}
}

class MPanel19 extends JPanel{
	public MPanel19 () {
		//Formas de declarar los campos
		JTextField campo1 = new JTextField("Texto por defecto");
		JTextField campo2 = new JTextField(5);
		JTextField campo3 = new JTextField("Texto por defecto",2);
		
		System.out.println(campo1.getText());//imprime el contenido del cuadro por consola
		System.out.println(campo1.getText().trim());// quita los espacios adicionales
		
		add(campo1);
		add(campo2);
		add(campo3);
	}
}