package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Comprobar un email mediante un JTextField y un JButton
 * Usamos 2 paneles, el principal BorderLayout el secundario que contiene FlowLayout standar
 * que es el que contiene el JTextField y el JButton
 */
public class CamposDeTexto2 {

	public static void main(String[] args) {
		MiMarco20 m20 = new MiMarco20 ();
		m20.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MiMarco20 extends JFrame{
	public MiMarco20 () {
		add(new MPanel20());
		setTitle("Campos de Texto");
		setBounds(600,300,600,350);
		setVisible(true);
		
	}
}

class MPanel20 extends JPanel{
	public MPanel20 () {
		//Formas de declarar los campos
		setLayout(new BorderLayout());
		JPanel p12 = new JPanel();
		p12.setLayout(new FlowLayout());
		//add(new JPanel().setLayout(new FlowLayout()));
		
		JLabel texto1= new JLabel("Email: ");
		resultado= new JLabel("",JLabel.CENTER);
		p12.add(texto1);
		campo1 = new JTextField(5);
		p12.add(campo1);
		add(resultado,BorderLayout.CENTER);
		boton= new JButton("Comprobar");
		boton.addActionListener(new ActionBoton());
		p12.add(boton);
		add(p12,BorderLayout.NORTH);
	}
	
	private class ActionBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int correcto = 0;
			String email= campo1.getText().trim();
			
			for (int i=0; i< email.length();i++) {
				if(email.charAt(i)=='@') {
					correcto++;
				}
			}
			if(correcto!=1) {
				resultado.setText("Incorrecto");
			}else resultado.setText("Correcto");
			
			System.out.println(campo1.getText());
			
		}
		
	}
	
	private JTextField campo1;
	private JButton boton;
	private JLabel resultado;
}
