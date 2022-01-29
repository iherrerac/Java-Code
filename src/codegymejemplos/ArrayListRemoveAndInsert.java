package codegymejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Remove and insert

*/

public class ArrayListRemoveAndInsert {

	    public static void main(String[] args) throws Exception {
	        ArrayList<String> list = new ArrayList<String>();
	        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	        String s = "";
	        
	        for (int i = 0; i < 5; i++){
	            list.add(i,r.readLine());
	        }
	        
	        for (int i=0; i<13;i++){
	            s = list.get(list.size()-1);
	            list.remove(list.size()-1);
	            list.add(0,s);
	        }
	        
	        Iterator<String> it = list.iterator();
	        
	        while(it.hasNext()){
	            System.out.println(it.next());
	        }
	    }
	}
