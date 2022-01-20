package codegym;

import java.io.*;
import java.util.Scanner;

public class Stream1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		InputStream inputStream = System.in;
//		Reader inputStreamReader = new InputStreamReader(inputStream);
//		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//		try {
//			String name = bufferedReader.readLine();//Read a string from the keyboard
//			String sAge = bufferedReader.readLine(); //Read a string from the keyboard
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//		
//		int nAge = Integer.parseInt(sAge); //Convert the string to a number.
//		
//		
//		//Example 2: A more compact version of the previous example:
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//		String name = reader.readLine();
//		String sAge = reader.readLine();
//		int nAge = Integer.parseInt(sAge);
//		
//		//Example 3 Even more compact
//		Scanner scanner = new Scanner(System.in);
//		String name = scanner.nextLine();
//		int age = scanner.nextInt();
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int days;
		int year = Integer.parseInt(b.readLine());
		if( year%400 == 0 || year%4 == 0) days = 366; //leap year
		else if (year%100 == 0 ) days = 365;//regular year
		else days = 365; //Anothers years are regular
		System.out.printf("Number of days in the year: %d",days);
		
	}

}
