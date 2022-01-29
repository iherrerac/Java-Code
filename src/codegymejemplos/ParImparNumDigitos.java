package codegymejemplos;

/* 
Describing numbers

*/

import java.io.*;

public class ParImparNumDigitos {

    public static void main(String[] args) throws Exception {
        
    	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    	int number=0;
    	while (number < 1 || number >999) 
    	number = Integer.parseInt(r.readLine());
    	
    	System.out.println("par o impar: " + esPar(number) + " digitos: " + cuentaDigitos(number));
    	
    	if (esPar(number));
    	else if (esPar(number));
    	
    }
    
    public static boolean esPar(int number) {
    	return (number%2 == 0);
    }
    public static int cuentaDigitos(int number) {
    	int cont = 1;
    	while (!(number/10 == 0)) {
    		number = number/10;
    		cont++;
    	}
    	return cont;
    }
    	
}
