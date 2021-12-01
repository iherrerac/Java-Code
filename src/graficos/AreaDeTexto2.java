package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Declarar un campo de area en un BorderLayout central y dos botones en el sur
 * uno para enviar texto y otro para deshabilitar el salto de linea
 * Todo en una clase, no recomendable porque pierde la modularidad
 */

public class AreaDeTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco24 m24 = new MiMarco24();
		m24.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m24.setVisible(true);
		m24.setLayout(new BorderLayout());//Esta vez vamos a establecer el Layout en el Marco
		
		
	}

}

class MiMarco24 extends JFrame{
	public MiMarco24() {
		setTitle("Areas de Texto 1");
		setBounds(100,100,600,300);
		p24Sur=new JPanel();
		p24Central= new JPanel();
		area= new JTextArea(5,20);
		JScrollPane scrollArea = new JScrollPane(area);
		//boton insertar
		insertar = new JButton("Insertar");
		insertar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				area.append("En un lugar de la mancha cuyo nombre no quiero acordarme.");
			}
			
		});
		//Boton salto de linea
		saltoLinea= new JButton("Salto de linea");
		saltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean salto =!area.getLineWrap();//Negacion, lo contrario
				area.setLineWrap(salto);
				
//				if(salto) {
//					saltoLinea.setText("Quitar salto");
//				}else saltoLinea.setText("Salto de linea");
				saltoLinea.setText(salto ? "Quitar salto":"Poner salto");
			}

			
		});
		p24Central.add(scrollArea);
		p24Sur.add(insertar);
		p24Sur.add(saltoLinea);
		add(p24Sur,BorderLayout.SOUTH);
		add(p24Central,BorderLayout.CENTER);
		
	}
	private JPanel p24Sur;
	private JPanel p24Central;
	private JTextArea area;
	private JButton insertar;
	private JButton saltoLinea;
}
