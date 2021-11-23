package graficos;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Marcos5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M5 MiMarco = new M5();
		MiMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class M5 extends JFrame{
	//Constructor
	public M5() {
		setVisible(true);
		setTitle("Fuentes");
		setBounds(200,200,400,400);
		P5 MiPanel = new P5();
		//Establee color de fondo de la lamina
		MiPanel.setBackground(Color.WHITE);
		// Establece el de todo lo que se dibuje en la lamina
		//MiPanel.setForeground(Color.RED);
		add(MiPanel);
	}
}

class P5 extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Contructor de la clase Font (String name, int style (Constante tipo de letra), int size)
		Font MiFuente = new Font("Arial", Font.BOLD, 26);
		g2.setFont(MiFuente);
		g2.setColor(Color.BLUE);
		g2.drawString("Juan",100,100);
		
		//Cambiar fuente esta vez declarada directamente en el metodo setFont
		g2.setFont(new Font("Currier", Font.ITALIC, 26));
		g2.setColor(Color.RED);
		g2.drawString("Juan", 100,130);
	
	}
}
