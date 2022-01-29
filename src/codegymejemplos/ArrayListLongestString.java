package codegymejemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListLongestString {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        Scanner s = new Scanner(System.in);
        int longestStringIndex = 0;
        
        
        for (int i = 0; i<5; i++ ){
            strings.add(s.next());
            longestStringIndex = (strings.get(i).length() > longestStringIndex) ? strings.get(i).length() : longestStringIndex;
        }
        
        Iterator it = strings.iterator();
        
        while (it.hasNext()){
            String longest = (String)it.next();
            //if (longestStringIndex == ((String)it.next()).length()) System.out.println(longest);
            if (longestStringIndex == longest.length()) System.out.println(longest);
        }
    }
}