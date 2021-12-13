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
 * Cambiar tamaño texto con Radio button version corta co bucle y metodo de creacion de botones
 */

public class A28CasillaRadioButton3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco28 m28 = new Marco28();
		m28.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco28 extends JFrame{
	public Marco28() {
		setTitle("Botones Radio 3");
		setBounds(100,150,600,300);
		add(new Panel28());
		setVisible(true);
	}
}

class Panel28 extends JPanel{
	public Panel28() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la mancha de cuyo nombre no quiero acordarme");
		add(texto,BorderLayout.CENTER);	
		laminaRadio = new JPanel();
		grupo = new ButtonGroup(); //Creamos grupo
		String[] textoBotones = {"Pequeño","Mediano","Grande","Muy Grande"};
		boolean[] arraychecks = {false,true,false,false};
		int[] ArraytamanoTexto= {10,12,18,24};
		
		for (int i = 0; i < ArraytamanoTexto.length; i++) {
			creaRadioButton(textoBotones[i], arraychecks[i], ArraytamanoTexto[i]);
		}
		add(laminaRadio,BorderLayout.SOUTH);
	}
	//Metodo para crer botones Radio button 3 parametros
	private void creaRadioButton(String nombre, boolean check,int tamanoTexto) {
		JRadioButton boton = new JRadioButton(nombre, check); //creamos el boton con el texto y el check de marcado o no
		grupo.add(boton);//agrupamos boton
		boton.addActionListener(new ActionListener() { //ponemos a la escucha
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif",Font.PLAIN,tamanoTexto));//Action Perfomrmed cambiar tamaño fuente 
			}
		});
		laminaRadio.add(boton); //Agregamos boton a la lamina
	}
	private ButtonGroup grupo;
	private JLabel texto;
	private JPanel laminaRadio;	
}
