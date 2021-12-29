package graficos;
import javax.swing.JOptionPane;

//Bucle for: Determina si un email tiene una arroba
//La segunda parte del programa pregunta por un numero y devuelve el factorial por consola
public class BucledeterminadosFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ver si un email tiene arroba
		String email;
		boolean arroba= false;
		
		email= JOptionPane.showInputDialog("Introduzca un email");
		
		for(int i=0; i< email.length();i++ ) {
			//si el caracte comparado es igual a arroba ponemos dicha variable a true
			if (email.charAt(i) == '@') {
				arroba=true;
			}
		}
		if (arroba == true) {
			System.out.println("El email es correcto");
		} else {
			System.out.println("El email es incorrecto");
		}
//------------------------------------------------------------------	
		// Factorial de un numero. Multiplicar un numero por todos los que le preceden
		Long resultado = 1L;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero"));
		
		for (int i = numero; i > 0; i--) {
			resultado = resultado*i;
		}
		System.out.println("El factorial de "+numero+" es "+resultado+".");
	}

	

}
