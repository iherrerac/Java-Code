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
 * Cambiar el comportamiento de los botones del Spinner y funcionen al reves
 * Clases internas anonimas: Video 99
 */
public class ControlSpinner2 {

	public static void main(String[] args) {
		Marco33 m33 = new Marco33();
		m33.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco33 extends JFrame{
	public Marco33 () {
		setTitle("JSpinner");
		setBounds(100,150,600,300);
		add(new Panel33());
		setVisible(true);
	}
}

class Panel33 extends JPanel{
	public Panel33() {
		//control que representa un valor numerico o de texto. Pordefecto
		//y para controlar los numeros, constructor (valor inicial,min, max, cuanto avanza) 
		control= new JSpinner(new SpinnerNumberModel(5,0,10,2));
		//Inicializamos el Spinner con la clase que nos hemos creado sobrescribiendo
		control1= new JSpinner(new MiModeloJSpinner());
		//El selector se adapta al tamaño del primer elemento, para establecer otro tamaño 
		//usamos setpreferredsize. Hay que pasarle un objeto de tipo dimension
		Dimension d = new Dimension(120,20);
		control.setPreferredSize(d);
		control1.setPreferredSize(d);
		add(control);
		add(control1);
	}
	//Clases internas anonimas
	private class MiModeloJSpinner extends SpinnerNumberModel{
		public MiModeloJSpinner() {		//Sobrescribir metodo que nos devuelve el valor siguiente para que nos devuelva el valor previo

			//Llamamos al constructor de SpinnerNumberModel (valor inicial,min, max, cuanto avanza) 
			super(5,0,10,2);
		}
		public Object getNextValue() {
			//Al poner la palabra super delante llamamos al metodo getPreviosValue de la clase padre
			return super.getPreviousValue();
		}
	
		public Object getPreviousValue() {
			return super.getNextValue();
		}
	}
	JSpinner control;
	JSpinner control1;
}