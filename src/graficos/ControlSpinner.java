package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

/*
 * Como construir varios Spinner
 */
public class ControlSpinner {

	public static void main(String[] args) {
		Marco32 m32 = new Marco32();
		m32.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco32 extends JFrame{
	public Marco32 () {
		setTitle("JSpinner");
		setBounds(100,150,600,300);
		add(new Panel32());
		setVisible(true);
	}
}

class Panel32 extends JPanel{
	public Panel32() {
		//control que representa un valor numerico o de texto. Pordefecto
		control= new JSpinner();
		//y para controlar los numeros, constructor (valor inicial,min, max, cuanto avanza) 
		control= new JSpinner(new SpinnerNumberModel(5,0,10,2));
		//texto mediante array de lista emdianteSpinnerListModel o de fechas SpinnerDateModel
		
		//SpinnerDateModel Nos pone directamente la fecha de hoy
		control1= new JSpinner(new SpinnerDateModel());
		//SpinnerListModel para lista de string
		String[] lista= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		control2= new JSpinner(new SpinnerListModel(lista));
		//El selector se adapta al tamaño del primer elemento, para establecer otro tamaño 
		//usamos setpreferredsize. Hay que pasarle un objeto de tipo dimension
		Dimension d = new Dimension(120,20);
		control2.setPreferredSize(d);
		add(control);
		add(control1);
		add(control2);
	}

	JSpinner control;
	JSpinner control1;
	JSpinner control2;
}