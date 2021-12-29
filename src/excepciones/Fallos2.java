package excepciones;
import java.io.EOFException;

import javax.swing.JOptionPane;

//Bucle for: Determina si un email tiene una arroba
//La segunda parte del programa pregunta por un numero y devuelve el factorial por consola
// En el video 147 generamos una excepcion manualmente

public class Fallos2 {

	public static void main(String[] args) {
		//Ver si un email tiene arroba
		String email= JOptionPane.showInputDialog("Introduzca un email");
		try{
			examinaEmail(email);
		}catch(EOFException e) {
			System.out.println("La direccion de email no es correcta");
		}
		
	}
	
	static void examinaEmail (String mail) throws EOFException{
		int arroba= 0;
		boolean punto= false;
		
		//si tiene menos de 3 caracteres lanzamos un error
		if (mail.length()<=3) {
			//Simplificamos codigo
			//ArrayIndexOutOfBoundsException miExcepcion = new ArrayIndexOutOfBoundsException();
			//throw miExcepcion;
			throw new EOFException();
		}else {
		
			for(int i=0; i< mail.length();i++ ) {
				//si el caracte comparado es igual a arroba ponemos dicha variable a true
				if (mail.charAt(i) == '@') arroba++;
				if (mail.charAt(i) == '.') punto=true;
			}
			
			if (arroba==1 && punto==true) {
				System.out.println("El email es correcto");
			} else {
				System.out.println("El email es incorrecto");
			}
		}
	}
	

}
