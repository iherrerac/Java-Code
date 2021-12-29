package graficos;
import javax.swing.*;
import java.util.*;

public class BuclesIndeterminadosWhileDowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Aplicacion Comparar contraseña		
//		String clave = "Israel";
//		String clave1 = "";
//		
//		while(clave.equals(clave1)==false) {
//			clave1 = JOptionPane.showInputDialog("Introduzca la contraseña");
//			if (clave.equals(clave1)== false) {
//				System.out.println("Contraseña incorrecta");	
//			}
//		System.out.println("Contraseña correcta");
//		}
		
//---------------------------------------------------------------------------------------------		
		// Aplicacion Adivina Numero
		
//		Scanner entrada = new Scanner(System.in);
//		//Random imprime un numero aleatorio entre 0,xxx y 1,000. 
//		//Si lo multiplico * 100, desplazo la coma y tengo un numero del 1 al 100
//		int aleatorio = (int)(Math.random()*10); 
//		int numero = 0;
//		int intentos = 0;
//		while (numero != aleatorio) {
//			intentos++;
//			System.out.println("Introduce numero");
//			numero=entrada.nextInt();
//			if (aleatorio > numero) {
//				System.out.println("Mas alto");
//			}else if(aleatorio < numero){
//				System.out.println("Mas bajo");
//			}
//		}
//		
//		System.out.println("numero correcto, intentos "+ intentos);

		// Peso ideal: Bucle Do-While
		
		int altura = 0;
		String genero;
		//Pasa al menos una vez por el bucle
		do {
			genero=JOptionPane.showInputDialog(" Introduzca su genero (H/M)");	
		} while (genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		// Pide altura y lo convierte a String 
		altura = Integer.parseInt(JOptionPane.showInputDialog(" Introduzca su altura"));
		
		//Valida si es hombre o mujer y resta 110 o 120 a la altura en funcion del genero 
		if ( genero.equalsIgnoreCase("H")== true) {
			System.out.println("Su peso ideal es "+ (altura - 110)+" Kg.(H)");
			
		} else {
			System.out.println("Su peso ideal es "+ (altura - 120)+" Kg.(M)");
		}
	}

}
