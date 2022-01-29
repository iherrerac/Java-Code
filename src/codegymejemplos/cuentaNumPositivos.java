package codegymejemplos;

import java.util.Scanner;

public class cuentaNumPositivos {

	public static void main(String[] args) {
        int[] arrNumbers = new int[3];
        Scanner s1 = new Scanner(System.in);
        
        for ( int i = 0; i< arrNumbers.length ; i++)
        arrNumbers[i] = s1.nextInt();
        System.out.print(cuentaPositivo(arrNumbers));
    }
    
    public static int cuentaPositivo(int[] numbers){
        int cont=0;
        for (int n : numbers){
          if (n>0) cont++;  
        } 
        return cont;
    }
}