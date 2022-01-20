package codegymejemplos;

/* 
Number of days in the year

*/

import java.io.*;

public class AnoBisiestooAnoNormal {
    public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int days;
		System.out.println("Introduzca un año:");
		int year = Integer.parseInt(b.readLine());
		if( year%400 == 0) days = 366; //leap year
		else if (year%100 == 0 ) days = 365;//regular year
		else if(year%4 == 0) days = 366; //leap year
		else days = 365; //Anothers years are regular
		System.out.printf("Number of days in the year: %d",days);
    }
}
