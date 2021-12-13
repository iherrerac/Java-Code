package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Cambiar tamaño texto con Radio button version larga
 */

public class A27CasillaRadioButton2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco27 m27 = new Marco27();
		m27.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco27 extends JFrame{
	public Marco27() {
		setTitle("Botones Radio 2");
		setBounds(100,150,600,300);
		add(new Panel27());
		setVisible(true);
	}
}

class Panel27 extends JPanel{
	public Panel27() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha de cuyo nombre no quiero acordarme");
		add(texto,BorderLayout.CENTER);	
		ButtonGroup grupo1 = new ButtonGroup();
		boton1 = new JRadioButton("Pequeño",false);
		boton2 = new JRadioButton("Mediano",true);
		boton3 = new JRadioButton("Grande",false);
		boton4 = new JRadioButton("Muy Grande",false);
		boton1.addActionListener(new EventoRadio());
		boton2.addActionListener(new EventoRadio());
		boton3.addActionListener(new EventoRadio());
		boton4.addActionListener(new EventoRadio());
		grupo1.add(boton1);
		grupo1.add(boton2);
		grupo1.add(boton3);
		grupo1.add(boton4);
		JPanel laminaRadio = new JPanel();
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		add(laminaRadio,BorderLayout.SOUTH);
		
	}
	
	private class EventoRadio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getSource().toString());
			if(e.getSource() == boton1) {
				texto.setFont(new Font("Serif",Font.PLAIN,10));	
			}else if(e.getSource() == boton2) {
				texto.setFont(new Font("Serif",Font.PLAIN,12));	
			}else if(e.getSource() == boton3) {
				texto.setFont(new Font("Serif",Font.PLAIN,18));	
			}else if(e.getSource() == boton4) {
				texto.setFont(new Font("Serif",Font.PLAIN,24));	
			}
		}
		
	}
	private JLabel texto; 
	private JRadioButton boton1;
	private JRadioButton boton2;
	private JRadioButton boton3;
	private JRadioButton boton4;
}
