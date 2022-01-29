package codegymejemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListDuplicaString {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < 10; i++){
            list.add(s.nextLine());
        }

        ArrayList<String> result = doubleValues(list);

        Iterator<String> it = result.iterator();
        
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = 0; i < list.size(); ){
            list.add(i,list.get(i));
            i+=2;
        }
        return list;
    }
}
