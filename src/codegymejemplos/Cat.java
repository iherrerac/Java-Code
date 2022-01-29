package codegymejemplos;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Static cats
ArrayList declarado como atributo e inicializado, agregamos a la lista cada vez que se cree un gato.
Podemos acceder a el atributo static desde el constructor con this.
Recorremos la coleccion con un Iterador.  

*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    
    public Cat() {
    }

    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            Cat miau = new Cat();
            cats.add(miau);
        }
        printCats();
    }

    public static void printCats() {
        Iterator<Cat> it = cats.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
