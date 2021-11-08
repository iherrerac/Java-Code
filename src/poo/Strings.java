package poo;

public class Strings {

	public static void main(String[] args) {
		
		//Recorrer un String: Buscar la arroba
		
		String email = "isra.herrera@hotmail.com";
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				System.out.println("Hay una Arroba en la posición "+(i+1));
			}
		}

	}

}
