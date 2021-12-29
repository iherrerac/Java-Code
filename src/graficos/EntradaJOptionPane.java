package graficos;
import javax.swing.JOptionPane;

public class EntradaJOptionPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		System.out.println("Hola, " + nombre + ", tu edad el año que viene sera "+(edad + 1)+" años.");

	}

}
