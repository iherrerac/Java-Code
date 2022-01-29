package codegymejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Playing Javarella

*/

public class ArrayListMultiplos3Multiplos2 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listNumBy3 = new ArrayList<Integer>();
        ArrayList<Integer> listNumBy2 = new ArrayList<Integer>();
        ArrayList<Integer> listNumByAll = new ArrayList<Integer>();
        
        for (int i = 0; i < 20; i++){
            list.add(Integer.parseInt(r.readLine()));
            if (list.get(i)%3 == 0) listNumBy3.add(list.get(i));
            if (list.get(i)%2 == 0) listNumBy2.add(list.get(i));
            if (!(list.get(i)%3 == 0) && !(list.get(i)%2 == 0)) listNumByAll.add(list.get(i));
        }
        printList(listNumBy3);
        printList(listNumBy2);
        printList(listNumByAll);
    }

    public static void printList(List<Integer> list) {
        for(int n: list){
            System.out.println(n);
        }
    }
}