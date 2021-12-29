package streams;

import java.io.*;

/*
 * Streams de flujo de caracteres
 * Escritura en un fichero de flujo de caracteres
 * Video 153
 */

public class EscribirFichero {

	public static void main(String[] args) {
		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir();
	}

}

class Escribiendo {
	public void escribir() {
		String frase = "esto es una prueba de escritura";
		try {
			//El true es si append o no
			FileWriter escritura = new FileWriter("C:/Users/casa/Desktop/textonuevo.txt",true); 
			for ( int i=0; i < frase.length();i++) {
			 escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
