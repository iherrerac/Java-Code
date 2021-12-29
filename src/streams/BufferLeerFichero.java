package streams;

import java.io.*;

/*
 * Streams de flujo de caracteres Buffer
 * Aplicacion que accede a un fichero ejemplo.txt en el escritorio mediante un Buffer
 * Video 154
 */

public class BufferLeerFichero {

	public static void main(String[] args) {
		LeerBufferFichero accediendo = new LeerBufferFichero();
		accediendo.lee();
	}

}
class LeerBufferFichero {
	
	public void lee() {
		try {
			entrada=new FileReader("C:/Users/casa/Desktop/ejemplo.txt");//ruta fichero
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea="";
			
			while(linea!= null) {
				linea = miBuffer.readLine();
				if (linea != null) System.out.println(linea);//El if para que no nos imprima el null
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
