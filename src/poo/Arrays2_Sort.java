package poo;
import java.util.Arrays;

public class Arrays2_Sort {
	/*
	 * Ordenar Arrays tipo Objeto. Metodo Arrays.sort.
	 * Hay que implementar la interface Compare y sobrescribir su metodo CompareTo
	 * CompareTo devuelve -1,0 o 1 En funcion de si es <, = o >
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comics[] miArray = new Comics[3];
		
		miArray[0]=new Comics("Batman", 101, "Grapa");
		miArray[1]=new Comics("Batman", 69, "Grapa");
		miArray[2]=new Comics("Batman", 80, "Grapa");
		
		Arrays.sort(miArray);
		
		//Imprimimos array con bucle mejorado
		for(Comics a:miArray) System.out.println(a.dameComics());	
	}
}

//Para poder ordenar, la clase Comics desde tener interfaz de Comparable
class Comics implements Comparable {
	
	public Comics(String nombre, int numero, String encuadernacion) {//Constructor
	this.nombre=nombre;
	this.numero=numero;
	this.encuadernacion=encuadernacion;
	id= idNext;
	idNext++;
	}
	
	public int compareTo(Object obj) {
		//Casting
		Comics com=(Comics)obj;
		//Comparamos valores para retorenar 1,0,o -1
		if(this.numero < com.numero) {
			return -1;
		}else if(this.numero > com.numero){
			return 1;
		}
		return 0;
	}
	
	String dameNombre() {//GETTER
		return nombre;
	}
	
	int dameId() {//GETTER
		return id;
	}
	String  dameComics() {//GETTER
		resumen="Id: "+this.id+", Colección: "+this.nombre+", numero: "+this.numero+", Enc: "+this.encuadernacion;
		return resumen;
	}
	
	private String nombre;
	int numero;
	String encuadernacion;
	private int id;
	private static int idNext=1;
	private String resumen;
}
