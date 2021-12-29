package graficos;
import java.util.Scanner;

public class BucleElseIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Introdue tu edad: ");
		Scanner entrada = new Scanner( System.in);
		
		int edad = entrada.nextInt();
		
		if (edad< 18) {
			System.out.println("Eres un adolescente");			
		}else if (edad < 40) {
			System.out.println("Eres joven");
		}else if (edad <65) {
			System.out.println("Eres maduro");			
		}else{
			System.out.println("cuidate");
		}

	}
}
