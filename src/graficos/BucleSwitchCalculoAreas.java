package graficos;
import java.util.*;
import javax.swing.*;

public class BucleSwitchCalculoAreas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opcion: \n1. Cuadrado \n2. Rectangunlo \n3. Triangulo \n4. Circulo");
		int opcion = entrada.nextInt();
		
		switch (opcion) {
		case 1:
			// El area de un cuadrado es lado al cuadrado
			// Hemos convertido la variable lado a int, aunque el metodo "pow" obliga a que sea double¿?
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado."));
			System.out.println("El area del cuadrado es "+ Math.pow(lado, 2));
			break;
			
		case 2:
			//El area de un rectangulo es base por altura
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base."));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura."));
			System.out.println("El area del rectangulo es "+ (base * altura));
			break;
			
		case 3:
			//Area de un triangulo es Base*altura dividido entre 2
			//Las variables base y altura ya estan definidas en el anterior case
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base."));
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura."));
			System.out.println("El area del triangulo es "+ ((base * altura)/2));
			break;
		case 4:
			//El area de un circulo es PI*Radio al cuadrado
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio."));
			System.out.print("El area del circulo es ");
			System.out.printf("%1.2f",Math.PI*(Math.pow(radio,2)));
			break;
		default:
			System.out.println("La opcion no es correcta.");
			break;
		}
		
	}

}
