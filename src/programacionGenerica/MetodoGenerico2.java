package programacionGenerica;

import java.util.GregorianCalendar;
/*
 * Video 166
 * Metodos genericos. Podemos pasar por argumento cualquier tipo de objeto.
 * Esta aplicacion devuelve el elemento menor de cualquier tipo de array que se le pase, siempre
 *  que implementen la inetrface comparable, como indicamos en el metodo, para poder 
 *  usar el compareTo
 */

public class MetodoGenerico2 {

	public static void main(String[] args) {
		
		String[] nombres = {"Jose","Maria","pepe"};
		System.out.println(MisMatrices2.getMenor(nombres));
		GregorianCalendar fechas[] = { new GregorianCalendar(2015,07,12),
				new GregorianCalendar(2014,07,12),
				new GregorianCalendar(2019,07,12),
				new GregorianCalendar(2000,07,12)
				};
		
		System.out.println(MisMatrices2.getMenor(fechas));
		}

	}



class MisMatrices2{
	
	//public accesible desde otras clases, static para metodo de clase y no necesitar instanciarlo
	//especificamos el argumento de tipo (<T>) , va a devolver un tipo String y 
	//va a recibir un array generico.
	public static <T extends Comparable> T getMenor (T[] array) {
		
		if (array==null || array.length ==0) {
				return null;
		}
		//El metodo compareTo de la interface Comparable se puede usar para comparar objetos
		//Meto el primer elemento en una variable y la comparo con el resto
		T elementoMenor= array[0];
		for (int i=1; i< array.length; i++) {
			if (elementoMenor.compareTo(array[i])>0) {//Si es positivo, este es el menor
				elementoMenor=array[i];
			}
		}
		return elementoMenor;
		
	}
}
