package programacionGenerica;

/*
 * Indicar el parametro generico , se suele usar la T, la U y la K
 * Video 165
 * video 167 clases genericas herencia y tipos comodin
 * Agregamos el metodo imprimeEmpleado usando un parametro de tipo comodin
 */

public class ClaseGenerica <T> {//Indicamos que la clase es generica con el parametro T
	
	public ClaseGenerica() {
		primero= null;
	}
	
	//Setter que recibe un objeto generico
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	//Metodo que recibe como argumento un generico de tipo empleado
	//puede recibir un tipo empleado o cualquier subclase que herede usando un tipo comodin "? extends"
	public static void imprimirTrabajador(ClaseGenerica<? extends Empleado> p) {
		Empleado primero = p.getPrimero();
		System.out.println(primero);
	}
	
	public T getPrimero() {
		return primero;
	}
	
	private T primero;

}
