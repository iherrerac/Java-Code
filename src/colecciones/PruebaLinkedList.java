package colecciones;

import java.util.*;

/* 
 * Video 184: LinkedList: ordenadas en orden de como las creamos por defecto.
 * Video 185: LinkedList: 2 listas enlazadas, una de paises y una de capitales. Las unimos
 * y luego eliminamos las posiciones pares de capitales.
 */
public class PruebaLinkedList {

	public static void main(String[] args) {
		LinkedList<String> personas= new LinkedList<String>();
		personas.add("Pepe"); // agrega al final de la lista
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		System.out.println(personas.size());//Imprime el tamaño
		ListIterator<String> it= personas.listIterator();
		it.next();//Entre la posicion 0 y la posicion 1
		it.add("Juan");//Podemos agregar con el Iterador.
		for( String persona: personas) {
			System.out.println(persona);
		}
		
		//Video 185: Listas enlazadas
		System.out.println("---------------");
		LinkedList <String> paises= new LinkedList<String>();
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Perú");
		
		LinkedList <String> capitales= new LinkedList<String>();
		capitales.add("Madrid");
		capitales.add("bogotá");
		capitales.add("DF");
		capitales.add("Lima");
//		System.out.println(paises);
//		System.out.println(capitales);
		
		ListIterator<String> it1= paises.listIterator(); 
		ListIterator<String> it2= capitales.listIterator();
		
		//Unir las dos listas enlazadas
		System.out.println("---- Unir las dos listas enlazadas:");
		while(it2.hasNext()) {//Mientras haya un elemento siguiente en capitales
			if(it1.hasNext()) {//Comprobare si tambien hay un siguiente elemento en paises
				it1.next();
			}
			it1.add(it2.next());
		}
		System.out.println(paises);
		//Subir el Iterador al principio de la lista
		it2 = capitales.listIterator();
		//Eliminar los pares
		System.out.println("---- Eliminar los elementos pares de lista capitales:");
		while(it2.hasNext()) {
			it2.next();
			if(it2.hasNext()) {
				it2.next();
				it2.remove();
			}
		}
		System.out.println(capitales);
		// Eliminamos los elementos de capitales de la lista paises
		System.out.println("---- Eliminamos los elementos de la lista capitales de la lista paises: ");
		paises.removeAll(capitales);
		System.out.println(paises);
	}

}
