package codegymejemplos;

/* 
Positive and negative numbers

*/

import java.io.*;

public class CuentaPosNeg {

	    public static void main(String[] args) throws Exception {
	            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	            int[] arrNumbers = new int[3];
	            
	            for (int i=0; i< arrNumbers.length; i++)
	            arrNumbers[i]= Integer.parseInt(r.readLine());
	            
	            positivoNegativo(arrNumbers);
	        }
	        private static void positivoNegativo(int[] numbers){
	            int contPos=0;
	            int contNeg=0;
	            for(int n : numbers) {
	                if(n >0) contPos++;
	                else if (n<0) contNeg++;
	            }
	            System.out.printf("Number of negative numbers: %d\n",contNeg);
	            System.out.printf("Number of positive numbers: %d\n",contPos);
	        }
	    }
