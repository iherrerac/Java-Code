package codegymejemplos;

import java.io.*;

public class NumeroMenor {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];
        int minimum;
         for ( int i = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        minimum = numbers[0];
        for ( int i = 1; i<(numbers.length) ; i++){
            minimum = min(minimum, numbers[i]);
            //System.out.println("El minimo es "+ minimum);
        }

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
