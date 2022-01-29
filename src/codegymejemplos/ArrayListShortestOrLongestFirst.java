package codegymejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/* 
Shortest or longest, which first ?

*/

public class ArrayListShortestOrLongestFirst {

    public static void main(String[] args) throws Exception {
	        ArrayList<String> list = new ArrayList<String>();
	        Scanner s = new Scanner(System.in);
	        int shortestString = 0;
	        int longestString = 0;
	        String cadena = "";
	        
	        for (int i = 0; i < 10; i++){
	            list.add(i,s.next());
	            if ( i == 0){
	                shortestString = list.get(i).length();
	                longestString = list.get(i).length();
	            } else {
	                shortestString = (shortestString < list.get(i).length())? shortestString : list.get(i).length();
	                longestString = (longestString > list.get(i).length())? longestString : list.get(i).length();
	            }
	            System.out.println("L: " + longestString + " S: "+ shortestString);
	        }
	        
	        Iterator<String> it = list.iterator();
	        
	        while(it.hasNext()){
	            cadena = it.next();
	            if (cadena.length() == shortestString){
	              System.out.println(cadena);
	              break;
	            } else if (cadena.length() == longestString){
	                    System.out.println(cadena);
	                    break;
	            }
	        }
	    }
	}