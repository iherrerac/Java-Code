package codegymejemplos;

import java.util.Scanner;

public class EsPar {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        if (number == 0) System.out.print("Zero");
        else if(number < 0 && !esPar(number)) System.out.print("Negative odd number");
        else if(number > 0 && esPar(number)) System.out.print("Positive even number");
        else if(number > 0 && !esPar(number)) System.out.print("Positive odd number");
        else if(number < 0 && esPar(number))System.out.print("Negative even number");
    }

	private static boolean esPar(int number) {
		return (number%2==0);
	}
}
