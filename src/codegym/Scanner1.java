package codegym;

import java.util.Scanner;

/* 
Ejercicos Scanner

*/

public class Scanner1 {
	
    public static void main(String[] args) throws Exception {
//    	// Introduce salario
//        Scanner n = new Scanner(System.in);
//        System.out.printf("I will earn %s per hour",n.nextLine());
//        n.close();
    	
        //Introduce un numero y 
        Scanner s = new Scanner(System.in);
        int a= s.nextInt();
        if (a<0) System.out.println(++a);
        else if (a == 0) System.out.println(a);
        else System.out.println(a*2);
        s.close();
    }
    
    
}
