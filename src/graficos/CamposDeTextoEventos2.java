package graficos;

//Marcos y paneles
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Botones y campos
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

//eventos
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

//Layouts
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

//Color
import java.awt.Color;

/*
 * Campo usuario y contraseña y comprobaciones. Envio de datos mediante un boton
 */

public class CamposDeTextoEventos2 {

	public static void main(String[] args) {
		Marco22 m22 = new Marco22();
		m22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}

class Marco22 extends JFrame{
	public Marco22() {
		setTitle("Eventos de Campos 2");
		setBounds(300,200,600,300);
		JPanel p22 = new Panel22();
		add(p22);
		setVisible(true);
	}
}

class Panel22 extends JPanel{
	public Panel22() {
		
		setLayout(new BorderLayout());
		JPanel pg22 =new JPanel();
		pg22.setLayout(new GridLayout(2,2));		
		add(pg22,BorderLayout.NORTH);
		
		JLabel etiqueta1 = new JLabel("Usuario");
		JLabel etiqueta2 = new JLabel("Contraseña");
		
		c_usuario = new JTextField(5);
		c_password = new JPasswordField(5);
		//objdocument, agregar como listener, y creacion de evento en una linea
		c_password.getDocument().addDocumentListener(new CompruebaPwd());
		pg22.add(etiqueta1);
		pg22.add(c_usuario);
		pg22.add(etiqueta2);
		pg22.add(c_password);
		
		JButton boton= new JButton("Enviar");
		add(boton,BorderLayout.SOUTH);
	}
	
	private class CompruebaPwd implements DocumentListener{

		@Override
		public void insertUpdate(javax.swing.event.DocumentEvent e) {
			char[] pwd=c_password.getPassword();
			if (pwd.length<6 || pwd.length>12) {
				c_password.setBackground(Color.RED);
			}else c_password.setBackground(Color.WHITE);
		}

		@Override
		public void removeUpdate(javax.swing.event.DocumentEvent e) {
			char[] pwd=c_password.getPassword();
			if (pwd.length<6 || pwd.length>12 ) {
				c_password.setBackground(Color.RED);
			}else c_password.setBackground(Color.WHITE);
		}

		@Override
		public void changedUpdate(javax.swing.event.DocumentEvent e) {
			
		}
		
		
	}
	
	JPasswordField c_password;
	JTextField c_usuario;
}
