package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Color;

/*
 * Aplicacion que cambia el color de fondo ( Listener) desde
 * multiples fuentes ( Botones, combinacion de teclas)
 */

public class EventosMultiplesFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MiMarco13 M13 = new MiMarco13();
		M13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

}

class MiMarco13 extends JFrame{
	
	public MiMarco13() {
		//setLayout(null);
		setVisible(true);
		setTitle("Multiples Fuentes");
		setBounds(150, 100, 600,400);
		add(new MiPanel13());
	}
}


class MiPanel13 extends JPanel{

	public MiPanel13() {

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);
		initBotones();
		initListener();
	}
	

	
	private void initBotones() {

		String[] textoBotones = {"azul","rojo","verde","blanco","negro","Rosa"};
		int[] setXBotones = {30,30,30,30,30,30};
		int[] setYBotones = {30,80,130,180,230,280};
		
		for ( int i=0; i<Botones.length;i++) {
			Botones[i]= new JButton(textoBotones[i]);
			Botones[i].setBounds(setXBotones[i],setYBotones[i],80,30);
			add(Botones[i]);
		}
	
	}
	
	private void initListener() {
		Color[] setColorFondo = {Color.BLUE,Color.RED,Color.GREEN,Color.WHITE,Color.BLACK,Color.PINK};
		for ( int i=0; i<Botones.length;i++) {
			Botones[i].addActionListener(new ColorFondoListener(setColorFondo[i]));
			
		}
	}
	
	public class ColorFondoListener implements ActionListener{
		public ColorFondoListener(Color c) {
			ColorFondo=c;
		}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setColorFondo[i];
				System.out.println(ColorFondo);
				setBackground(ColorFondo);
			}
			
		private Color ColorFondo;
	}
	
	int numBotones = 6;
	JButton[] Botones= new JButton[numBotones];

}

