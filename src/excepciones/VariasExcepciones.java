package excepciones;

import javax.swing.JOptionPane;
//Video 148,149 (finally)

public class VariasExcepciones {

	public static void main(String[] args) {
		try {
			division();
		}catch(ArithmeticException e) {
			//dividiendo por cero
			System.out.println("Estas dividiendo por cero");
		}catch(NumberFormatException e) {
			//INtroduce texto en vez de numero
			System.out.println("No has introducido un numero entero"+e.getMessage());
			System.out.println("Se ha generado un error de tipo: "+e.getClass().getName());
		}
	}
	
	static void division() {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
		System.out.println("El resultado es: "+ num1/num2);
	}

}
