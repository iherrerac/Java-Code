package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import java.awt.Font;

public class SelectorBarraDeslizante {

	public static void main(String[] args) {
		Marco30 m30 = new Marco30();
		m30.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco30 extends JFrame{
	public Marco30() {
		setTitle("Barra deslizante");
		setBounds(100,150,600,300);
		add(new Panel30());
		setVisible(true);
	}
}
class Panel30 extends JPanel{
	public Panel30() {
		//Contrutor JSlider(int orientation, int min, int max, int value(es la posicion inicial del slider))
		JSlider control = new JSlider(0,100,50);
		//Puedes cambiar tb la horientacion con el metodo setOrientation
		control.setOrientation(SwingConstants.VERTICAL);
		//Marcas
		control.setMajorTickSpacing(25);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		//Labels del slider
		control.setFont(new Font ("Serif",Font.ITALIC,12));
		control.setPaintLabels(true);
		//Para que el deslizador se mueva de marca en marca
		control.setSnapToTicks(true);
		add(control);
	}
}