package ficherosyDirectorios;

import java.io.*;
/*
 * Video 159, voy por 160
 * Archivos y directorios
 * Aplicacion que mira una ruta y detecta si es un archivo o un directorio.
 * 
 * video 160 rutas universales para asegurarse la compatibilidad con cualquier SO
 * Creacion de archivos y directorios, y escribir en el archivo, y eliminar
 * 
 */

public class Rutas {

	public static void main(String[] args) {
		//Si no especificamos usa la ruta por defecto de nuestro proyecto
		File archivo = new File("ejemplo_archivo");
		//Imprime la ruta absoluta
		System.out.println(archivo.getAbsolutePath());
		//Mira a ver si existe
		System.out.println(archivo.exists());
		
		File ruta = new File("c:/users/casa/Desktop");
		System.out.println(ruta.getAbsolutePath());
		String[] nombre_archivos = ruta.list();
		for (String e:nombre_archivos) {
			System.out.println(e);
			//Sobrecarga constructores File
			//Examina a cada vuelta de bucle el array de archivos y directorios
			//indicamos la ruta primkero y anexa el archivo o directorio del array conseguido con list
			File f= new File(ruta.getAbsoluteFile(),e);
			//Con cada vuelta preguntamos si se trata de un directorio
			if(f.isDirectory()) {
				String[] subcarpeta = f.list();
				System.out.println("------------------");
				for (String g: subcarpeta) {
					System.out.println(g);
				}
			}
		}
		//Crear un directorio
		//Ruta con separadores universales, mas nombre de directorio a crear
		File ruta2 = new File("c:"+File.separator+"users"+File.separator+"casa"+File.separator+"Desktop"+File.separator+"DirectorioPrueba");
		ruta2.mkdir();
		
		//Crear un archivo
		File ruta3 = new File("c:"+File.separator+"users"+File.separator+"casa"+File.separator+"Desktop"+File.separator+"archivoprueba.txt");
		try {
			ruta3.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Crear un archivo y escribir en el
		File ruta4 = new File("c:"+File.separator+"users"+File.separator+"casa"+File.separator+"Desktop"+File.separator+"archivoprueba2.txt");
		String archivoDestino = ruta4.getAbsolutePath();
		Escribiendo accede_es= new Escribiendo();
		accede_es.escribir(archivoDestino);
		
		//Borra archivo y directorio
		ruta2.delete();
		ruta3.delete();
	}
	
	

}


class Escribiendo{
	public void escribir(String rutaArchivo) {
		String frase= "Esto es un ejemplo.";
		try {
		FileWriter escritura = new FileWriter (rutaArchivo);
		escritura.write(frase);
		escritura.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}


