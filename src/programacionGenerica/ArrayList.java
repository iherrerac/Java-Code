package programacionGenerica;

import java.util.*;
import java.util.ArrayList.*;

/*
 * Video 161,162,163
 * ArrayList
 */

public class ArrayList {

	public static void main(String[] args) {
		/*Empleado[] listaEmpleados = new Empleado[3];
		listaEmpleados[0] = new Empleado ("Ana",45,2500);
		listaEmpleados[1] = new Empleado ("Antonio", 55,2000);
		listaEmpleados[2] = new Empleado ("Antonio", 55,2000);*/
		
		//El constructor por defecto es para 10 elementos maximos, 
		//a partir del decimo, crea una copia y gasta mas recursos, 
		//por lo que conviene indicar si tiene mas de 10
		
		java.util.ArrayList <Empleado> listaEmpleados = new java.util.ArrayList <Empleado>();
		listaEmpleados.add(new Empleado("Ana",45,2500));
		listaEmpleados.add(new Empleado("Antonio", 55,2000));
		listaEmpleados.add(new Empleado("Olga", 22,2200));
		listaEmpleados.add(new Empleado("Jorge", 55,2000));
		listaEmpleados.add(new Empleado("Pepe", 22,2200));
		listaEmpleados.add(new Empleado("Luis", 55,2000));
		listaEmpleados.add(new Empleado("Cantero", 22,2200));
		// Indicar el lugar dentro del array con set(Cuidado sobrescribe)
		listaEmpleados.set(1,new Empleado("Paco", 30,2000));
		//Imprime una posicion
		System.out.println("Posicion 3" +listaEmpleados.get(2).dameDatos());
		System.out.println("-------------------------");
		
		//Capacidad minima del Array
		listaEmpleados.ensureCapacity(1);
		
		//Recorta el espacio sobrante de esa memoria vacia para que el ArrayList 
		//quede de un tamaño adecuado, optimizacion de recursos.
		listaEmpleados.trimToSize();
		
		//recorrer el arraylist con foreach
		for ( Empleado e:listaEmpleados) {
			System.out.println(e.dameDatos());
		}
		System.out.println("-------------------------");
		
		//recorrer el arraylist con for normal
		for ( int i=0; i< listaEmpleados.size(); i++) {
			Empleado e  =listaEmpleados.get(i);
			System.out.println(e.dameDatos());
		}
		System.out.println("-------------------------");
		
		//Usar un array List con un array normal
		Empleado[] arrayEmpleados = new Empleado[listaEmpleados.size()];
		listaEmpleados.toArray(arrayEmpleados);
		for (int i=0; i<arrayEmpleados.length; i++) {
			System.out.println(arrayEmpleados[i].dameDatos());
		}
		
		//Recorrer con un iterador
		System.out.println("-------------------------");
		Iterator <Empleado> miIterador = listaEmpleados.iterator();
		//Con hasNext preguntamos Si tiene mas elementos o no 
		while(miIterador.hasNext()) {
			System.out.println(miIterador.next().dameDatos());
		}
	}
	

}

class Empleado{
	public Empleado(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public String dameDatos() {
		return ("El empleado se llama "+ nombre+". Tiene "+edad+" años. Y un salario de "+salario);
	}
	
	private String nombre;
	private int edad;
	private double salario;
}


