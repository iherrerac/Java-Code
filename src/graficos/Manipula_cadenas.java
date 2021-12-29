package graficos;

public class Manipula_cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = "Juan";
//		
//		//charAt para localizar un caracter
//		System.out.println("Mi nombre es: " + nombre); 
//		System.out.println("Mi nombre mide: " + nombre.length()); // Longitud cadena
//		System.out.println("La primera letra de tu nombre es: "+ nombre.charAt(0)); //primera letra
//		int ultimaLetra = nombre.length() - 1;
//		System.out.println("La última letra de mi nombre es: " +nombre.charAt(ultimaLetra));
//		
//		//Substrings
//		String frase = "Hoy es un estupendo dia para aprender a programar Java";
//		String fraseParcial = frase.substring(24, frase.length());
//		
//		System.out.println("Substring: " + fraseParcial);
//		fraseParcial.equalsIgnoreCase(fraseParcial)

		//equals e equalIgnoreCase
		String alumno1 = "David";
		String alumno2 = "david";
		
		System.out.println(alumno1.equalsIgnoreCase(alumno2));
	}

}
