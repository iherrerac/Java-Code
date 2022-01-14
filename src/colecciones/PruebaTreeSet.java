package colecciones;

import java.util.*;

/*
 * Video 186: Colecciones: TreeSet
 * Orden alfabetico por defecto. Por que String implementa la interface Comparable 
 * y el metodo compareTo() para comparar objeto devuelve un int. en funcion de si es 0 - o + ordena
 * Hay que asegurarse que la clase de la que vaya a ser el TreeSet implemente la interface comparable
 * y sobrescribir el metodo a como queramos ordenar
 * video 187: Que pasa si queremos crear otra coleccion que ordene esta vez por orden alfabetico?
 * Video 188: Y que pasa si no tenemos el metodo compareTo() en la clase generica que usamos?
 * Nos crearemos una clase que implemente comparator. Tambien podemos hacerlo mediante una clase interna anonima
 */

public class PruebaTreeSet {

	public static void main(String[] args) {
		TreeSet<String> ordenaPersonas= new TreeSet<String>();
		
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");
		
		for ( String persona: ordenaPersonas) {
			System.out.println(persona);
		}
		
		System.out.println("----- Ordenamos por numero de articulo:");
		
		Articulo primero= new Articulo(1,"Primer articulo");
		Articulo segundo= new Articulo(200,"este es el segundo articulo");
		Articulo tercer= new Articulo(3,"Tercer articulo");
		
		TreeSet <Articulo> ordenaArticulos = new TreeSet<Articulo>();

		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		for (Articulo a: ordenaArticulos) {
			System.out.println(a.getDescripcion());
		}
		
		System.out.println("----- Ordenamos por Descripcion:");
		
		//Objeto comparador
		Articulo comparadorArticulos= new Articulo();//usamos constructor sin parametros
		//Pasamos como parametro el objeto comparador. Conseguiremos así ordenar alfabeticamente 
		
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		
		for (Articulo a : ordenaArticulos2) {
			System.out.println(a.getDescripcion());
		}
		
		System.out.println("----- Ordenamos por Descripcion (Clase sin Comparator, creamos una clase):");
		Articulo2 primero1= new Articulo2(1,"Primer articulo");
		Articulo2 segundo2= new Articulo2(200,"este es el segundo articulo");
		Articulo2 tercer3= new Articulo2(3,"Tercer articulo");
		
		//Creamos comparador con la clase que hemos creado para ello
		ComparadorArticulos compara_articulo = new ComparadorArticulos(); 
		TreeSet<Articulo2> ordenaArticulos3 = new TreeSet<Articulo2>(compara_articulo);
		ordenaArticulos3.add(primero1);
		ordenaArticulos3.add(segundo2);
		ordenaArticulos3.add(tercer3);
		
		for(Articulo2 a:ordenaArticulos3) {
			System.out.println(a.getDescripcion());
		}
		
		System.out.println("----- Ordenamos por Descripcion (Clase sin Comparator, con clase abstracta):");
		//Mediante clase interna anonima. No hace falta crear el comparador
		TreeSet<Articulo2> ordenaArticulos4 = new TreeSet<Articulo2>(new Comparator<Articulo2>() {
			@Override
			public int compare(Articulo2 o1, Articulo2 o2) {
				return o1.getDescripcion().compareTo(o2.getDescripcion());
			}
		});
		
		ordenaArticulos4.add(primero1);
		ordenaArticulos4.add(segundo2);
		ordenaArticulos4.add(tercer3);
		
		for(Articulo2 a:ordenaArticulos4) {
			System.out.println(a.getDescripcion());
		}
	}
}

class Articulo implements Comparable<Articulo>, Comparator<Articulo>{//La interface Comparable admite un generico como argumento
	public Articulo() {
		
	}
	
	public Articulo(int num, String desc) {
		numero_articulo=num;
		descripcion= desc;
	}
	
	@Override
	//Sobrescribimos el metodo compareTo para que ordene por numerode articulo
	public int compareTo(Articulo o) {
		// compara un articulo con otro objeto que recibe por parametro;
		return (numero_articulo-o.numero_articulo);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	private int numero_articulo;
	private String descripcion;
	
	@Override
	//Compara ordenando alfabeticamente las descripciones
	public int compare(Articulo o1, Articulo o2) {
		return o1.getDescripcion().compareTo(o2.getDescripcion());
	}
}

//Creamos otro objeto articulo para el ejemplo del video 188 
// que pasa si tenemos que usar una clase que no implemente Comparable?
//Tenemos que crear una subclase comparador
class Articulo2 implements Comparable<Articulo2>{
	public Articulo2(int num, String desc) {
		numero_articulo=num;
		descripcion= desc;
	}
	
	@Override
	//Sobrescribimos el metodo compareTo para que ordene por numerode articulo
	public int compareTo(Articulo2 o) {
		// compara un articulo con otro objeto que recibe por parametro;
		return (numero_articulo-o.numero_articulo);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	private int numero_articulo;
	private String descripcion;
}

//Creamos clase comparador ejemplo Video 187
class ComparadorArticulos implements Comparator<Articulo2>{

	@Override
	//Ordenamos segun descripciones
	public int compare(Articulo2 o1, Articulo2 o2) {
		return o1.getDescripcion().compareTo(o2.getDescripcion());
	}
}
