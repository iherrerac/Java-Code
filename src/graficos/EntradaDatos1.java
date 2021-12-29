package graficos;
import java.util.Scanner;

public class EntradaDatos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos instancia tipo Scanner
		Scanner entrada = new Scanner(System.in);
		String nombre;
		int edad;
		
		System.out.println("Introduce tu nombre: ");
		nombre = entrada.nextLine();
		System.out.println("Introduce tu Edad: ");
		edad = entrada.nextInt();
		System.out.println("Hola, " + nombre +" el año que viene cumpliras " + (edad+1) +" años.");

	}

}
