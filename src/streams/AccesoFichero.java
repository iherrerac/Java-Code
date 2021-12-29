package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Streams de flujo de caracteres
 * Aplicacion que accede a un fichero ejemplo.txt en el escritorio
 * Video 152
 */

public class AccesoFichero {

	public static void main(String[] args) {
		LeerFichero accediendo = new LeerFichero();
		accediendo.lee();
	}

}
class LeerFichero {
	
	public void lee() {
		try {
			entrada=new FileReader("C:/Users/casa/Desktop/ejemplo.txt");//ruta fichero
			int c= 0;
			
			while(c!=-1) {//mientras c no sea -1, caracter que marca final del fichero
				c=entrada.read();// Código primer caracter
				char letra = (char)c;
				System.out.print(letra);
			}
			
		//} catch (FileNotFoundException e) { 
		} catch (IOException e) { // Excepcion superior que engloba todas las excepciones
			System.out.println("No se ha encontrado el archivo.");
		}finally {
			
			try {
				entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	FileReader entrada;
}
