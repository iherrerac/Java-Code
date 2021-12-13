package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;

/*
 * Aplicacion que cambia el tamaño de letra con una barra deslizante
 */
public class A31SelectorBarraDeslizante2 {

	public static void main(String[] args) {
		Marco31 m31 = new Marco31();
		m31.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco31 extends JFrame{
	public Marco31() {
		setTitle("Barra deslizante 2");
		setBounds(100,150,600,300);
		add(new Panel31());
		setVisible(true);
	}
}
class Panel31 extends JPanel{
	public Panel31() {
		setLayout(new BorderLayout());
		texto= new JLabel("En un lugar de la mancha ...");
		add(texto,BorderLayout.CENTER);
		//Slider tamaño de letra minimo y maximo y tamaño por defecto
		control= new JSlider(8,50,12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif",Font.ITALIC,12));
		control.addChangeListener(new EventoSlider());
		JPanel laminaSur = new JPanel();
		laminaSur.add(control);
		add(laminaSur,BorderLayout.SOUTH);
		
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			contador= control.getValue();
			System.out.println("Estas manipulando el deslizante. Contador: "+ contador);
			texto.setFont(new Font("Serif",Font.ITALIC,contador));
		}
		
	}
	private JLabel texto;
	private JSlider control;
	private int contador;
}