package programacionGenerica;

/*
 * Indicar el parametro generico , se suele usar la T, la U y la K
 * Video 165
 */

public class ClaseGenerica <T> {//Indicamos que la clase es generica con el parametro T
	
	public ClaseGenerica() {
		primero= null;
	}
	
	//Setter que recibe un objeto generico
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	public T getPrimero() {
		return primero;
	}
	
	private T primero;

}
