package codegymejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Expressing ourselves more concisely

*/

public class ArrayListShortestString {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int shortestString = 0;
        String s = "";
        
        for (int i = 0; i <5; i++){
            strings.add(i,r.readLine());
            if (i == 0) shortestString = strings.get(i).length();
            else shortestString = (strings.get(i).length() < shortestString )? strings.get(i).length() : shortestString;
            //System.out.println(shortestString);
        }
        Iterator<String> it = strings.iterator();
        while(it.hasNext()){
            s = it.next().toString();
            if (s.length() == shortestString) System.out.println(s);
        }
        
    }
}
