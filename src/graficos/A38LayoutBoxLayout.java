package graficos;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;

/*
 * Video 115
 * Creamos una BoxLayout vertical que contendra 3 box Horizontales
 * una para usuario otra para contraseña y otra con dos botones que ajustaran su 
 * separacion segun redimensionemos la ventana
 */

public class A38LayoutBoxLayout {

	public static void main(String[] args) {
		Marco38 m38 = new Marco38();
		m38.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m38.setVisible(true);
	}
}

class Marco38 extends JFrame{
	public Marco38() {
		setTitle("Disposicion en Box Layout");
		setBounds(100,200,200,200);
		setLayout(new BorderLayout());
		//Etiquetas
		JLabel rotuloUsuario= new JLabel("Usuario");
		JLabel rotuloPwd= new JLabel("contraseña");
		//Campos
		JTextField usuario = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		usuario.setMaximumSize(usuario.getPreferredSize());
		pwd.setMaximumSize(pwd.getPreferredSize());
		//Botones
		JButton boton1 = new JButton("Aceptar");
		JButton boton2 = new JButton("Cancelar");
		//Paneles cajas
		Box CajaV1= Box.createVerticalBox();
		Box CajaH1 =Box.createHorizontalBox();
		Box CajaH2 =Box.createHorizontalBox();
		Box CajaH3 =Box.createHorizontalBox();
		//Agregamos las cajas horizontales a la vertical
		CajaV1.add(CajaH1);
		CajaV1.add(CajaH2);
		CajaV1.add(CajaH3);
		//Agregamos la Caja vertical al marco
		add(CajaV1,BorderLayout.CENTER);
		//Agregamos componentes
		CajaH1.add(rotuloUsuario);
		CajaH1.add(Box.createHorizontalStrut(10));//Separacion entre elementos
		CajaH1.add(usuario);
		
		CajaH2.add(rotuloPwd);
		Box.createHorizontalStrut(10);
		CajaH2.add(pwd);
		
		CajaH3.add(boton1);
		CajaH3.add(Box.createGlue());//Espacio auto-redimensionable entre objetos
		CajaH3.add(boton2);
	
	}	
}



