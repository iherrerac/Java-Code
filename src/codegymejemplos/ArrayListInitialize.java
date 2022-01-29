package codegymejemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* 
More Sam-I-Am: Vemos varias forma sde inicializar un ArrayList

*/

public class ArrayListInitialize {

    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"Sam","I","Am");
            list.add(1,"Ham");
            list.add(3,"Ham");
        
     Iterator<String> it = list.iterator();
     
     while(it.hasNext()){
         System.out.println(it.next());
     }
    }
}
