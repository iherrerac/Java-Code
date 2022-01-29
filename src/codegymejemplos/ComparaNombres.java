package codegymejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparaNombres {

	public static void main(String[] args) throws IOException {
	        BufferedReader s1 = new BufferedReader(new InputStreamReader(System.in));
	        BufferedReader s2 = new BufferedReader(new InputStreamReader(System.in));
	        String nombre1 = s1.readLine();
	        String nombre2 = s2.readLine();
	        if(nombre1.equals(nombre2))System.out.print("The names are identical");
	        else if(nombre1.length() == nombre2.length()) System.out.print("The names are the same length");
	    }
	}
