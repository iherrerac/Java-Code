package codegymejemplos;

/* 
Sorting three numbers descending

*/

import java.io.*;
import java.util.Arrays;

	public class OrdenaDescendente {
	    public static void main(String[] args) throws Exception {
	        int[] arrNums = new int[3];
	        for ( int i= 0; i <3; i++){
	            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
	            arrNums[i] =Integer.parseInt(s.readLine());
	        }
	       Arrays.sort(arrNums);
	       System.out.println(arrNums[2]+" "+arrNums[1]+" "+arrNums[0]);
		}
	}
