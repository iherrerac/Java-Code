package codegymejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Shuffled just in time
Use the keyboard to enter 2 numbers N and M.
Enter N strings and put them in a list.
Move the first M strings to the end of the list.
Display the list, each value on a new line.

Note:
you must not create more than one list.

*/

public class ArrayListAddAndRemovefirst {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        String st = "";
        
        for (int i = 0; i < N; i++){
            list.add(reader.readLine());
        }

        for (int i = 0; i < M; i++){
            list.add(list.get(0));
            list.remove(0);
        }
        
        for (String s: list){
            System.out.println(s);
        }
    }
}