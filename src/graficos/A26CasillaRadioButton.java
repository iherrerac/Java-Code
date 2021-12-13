package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
/*
 * Botones de radio, como declararlos
 */

public class A26CasillaRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco26 m26 = new Marco26();
		m26.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco26 extends JFrame{
	public Marco26() {
		setTitle("Casillas de radio");
		setBounds(100,200,500,300);
		add (new Panel26());
		setVisible(true);
	}
}

class Panel26 extends JPanel{
	public Panel26() {
		ButtonGroup miGrupo1 = new ButtonGroup();
		JRadioButton boton1 = new JRadioButton("Azul",false);
		JRadioButton boton2 = new JRadioButton("Rojo",true);
		JRadioButton boton3 = new JRadioButton("Verde",false);
		//Agregamos los botones al grupo, solo amrcara uno
		miGrupo1.add(boton1);
		miGrupo1.add(boton2);
		miGrupo1.add(boton3);
		//agregamos los botones a la lamina, no se puede agregar el grupo
		add(boton1);
		add(boton2);
		add(boton3);
	}
	
}