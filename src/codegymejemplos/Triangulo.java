package codegymejemplos;

/* 
Rule of the triangle
A triangle can exist only if the sum of two of its sides is greater than the third side.
You need to compare each side with the sum of the other two.
If even one side is larger or equal to the sum of the other two sides, then no such triangle exists.
*/

import java.io.*;

public class Triangulo {

    public static void main(String[] args) throws Exception {
        int a,b,c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());
        if(a+b > c && a+c > b && c+b > a) System.out.println("The triangle is possible.");
        else System.out.println("The triangle is not possible.");
    }

}
