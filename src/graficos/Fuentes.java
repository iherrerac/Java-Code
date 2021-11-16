package graficos;

import java.awt.GraphicsEnvironment;//Para las fuentes instaladas en el sistema
import javax.swing.*; 

/*
 * Aplicacion que busca si una fuente está instalada en el sistema
 */

public class Fuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String f = JOptionPane.showInputDialog("Introduce Nombre de la Fuente a buscar");
		boolean estaLaFuente = false;
		
		//Almacenar en un array todos los tipos de fuentes que tengo en el sistema.
		String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		//Recorremos el Array y mostramos por pantalla las fuentes
		for (String fuente : nombresDeFuentes) {
			if (fuente.equalsIgnoreCase(f)) estaLaFuente = true;
		}
		
		if(estaLaFuente) System.out.println("La fuente "+f+" está instalada en el sistema"); else System.out.println("La fuente "+f+" No está instalada en el sistema");
		
	}

}
