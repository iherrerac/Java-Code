package streams;

import java.io.*;
/*
 * Streams FLujo de caracteres
 * Aplicacion que copia una imagen que leemos y pasamos a un array, que copiaremos
 * Video 156
 */
public class LecturaEscrituraByte {

	public static void main(String[] args) {
		// Codigo para lectura 
		int contador = 0;
		int[] datosEntrada = new int[1610];//Dato que hemos sacado de contador
		
		try {
			FileInputStream archivoLectura = new FileInputStream("C:/Users/casa/Desktop/icono.jpg");
			boolean finalArchivo = false;
			while (!finalArchivo) {
				int byteEntrada = archivoLectura.read(); //leemos
				
				if (byteEntrada != -1) datosEntrada[contador] = byteEntrada;//mientras no llegue al final
				else finalArchivo= true;// Si llega al final,  sal del bucle
				
				System.out.println(datosEntrada[contador]);
				contador++;
			}
			archivoLectura.close();
		}catch(IOException e) {
			System.out.println("Error al acceder a la imagen");
		}
		
		System.out.println(contador);//Cuantos bytes tiene
		creaFichero(datosEntrada);
	}
	
	static void creaFichero(int[] arrayDatos) {
		try {
			FileOutputStream ficheroNuevo = new FileOutputStream("C:/Users/casa/Desktop/iconoCopia.jpg",true);
			for (int i = 0; i < arrayDatos.length; i++) {
				ficheroNuevo.write(arrayDatos[i]);
			}
			ficheroNuevo.close();
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}

}
