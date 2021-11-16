package graficos;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		setBounds(200,200,600,400);
		P5 MiPanel = new P5();		
	}
}

class P5 extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Font MiFuente = new Font("Arial", Font.BOLD, 26);
		g2.drawString("Juan", 250,250);
	}
}
