package graficos;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

//Paneles, Dibujar graficos y texto con JPanel
public class Marcos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTexto M= new MarcoTexto();
		M.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoTexto extends JFrame{

	public MarcoTexto () {
		setTitle("Primer texto");
		setVisible(true);
		setBounds(400,200,600,450);
		//Contruimos Panel
		Panel p = new Panel();
		//Agregamos panel
		add(p);
	}
}
class Panel extends JPanel{
	
	//Sobrescribimos metodo paintComponent
	public void paintComponent (Graphics g) {
		//Llamada al metodo paintComponent de la clase padre para que haga su trabajo
		super.paintComponent(g);
		// Le decimos que "dibuje" el texto
		g.drawString("Estamos aprendiendo Swing",100,100);
	}
}
