package programacionGenerica;

/*
 * Metodos genericos. Podemos pasar por argumento cualquier tipo de objeto
 * Esta aplicacion devuelve el numero de elementos de cualquier tipo de array que se le pase
 */

public class MetodoGenerico {

	public static void main(String[] args) {
		
		String[] nombres = {"Jose","Maria","pepe"};
		
		//Las siguientes dos formas son correctas
		System.out.println(MisMatrices.getElementos(nombres));
		System.out.println(MisMatrices.<String>getElementos(nombres));
		
		Empleado[] listaEmpleados = {new Empleado("Ana",45,2200),
				new Empleado("Ana",45,2200),
				new Empleado("Ana",45,2200),
				new Empleado("Ana",45,2200),
						};
		System.out.println(MisMatrices.getElementos(listaEmpleados));

	}

}

class MisMatrices{
	
	//public accesible desde otras clases, static para metodo de clase y no necesitar instanciarlo
	//especificamos el argumento de tipo (<T>) , va a devolver un tipo String y 
	//va a recibir un array generico.
	public static <T> String getElementos (T[] array) {
		return "El array tiene "+(array.length)+" elementos";
		
	}
}
