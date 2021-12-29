package graficos;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author usr
 *
 */
public class CalculosMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Capturamos por pantalla un string con JoptionPane, lo convertimos al tipo Double
		 *  con el metodo parseDouble de la clase Double.
		 */
		
		Double num1 = Double.parseDouble(JOptionPane.showInputDialog("Introduce numero"));
		
		//el metodo sqrt de la clase Math devuelve un double
		double raiz = Math.sqrt(num1);
		
		System.out.print("La raiz cuadrada de "+ num1 + " es ");
		//Printf para dar formato, 1.2 = 2 decimales, 1.4 = 4 decimales
		System.out.printf("%1.2f", raiz);
		
		
	}

}
