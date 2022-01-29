package codegymejemplos;

/* 
Do we have a pair?

*/

import java.io.*;

public class NumerosDuplicados {
    public static void main(String[] args) throws Exception {
    	int[] arrNumeros = new int[3];
    	for (int i= 0; i < 3; i++) {
    	BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    	arrNumeros[i]=Integer.parseInt(s.readLine());
    	}
    	findEquals(arrNumeros);
    }
    
    public static void findEquals(int[] nums) {
    	if(nums[0] == nums[1] || nums[0] == nums[2]) System.out.println(nums[0]);
    	if(nums[1] == nums[0] || nums[1] == nums[2]) System.out.println(nums[1]);
    	if(nums[2] == nums[0] || nums[2] == nums[1]) System.out.println(nums[2]);
    }
}
