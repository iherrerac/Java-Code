package codegymejemplos;

/* 
Crossing the road blindly
The pedestrian traffic light is programmed as follows:
at the beginning of each hour, the green signal is on for three minutes,
then the signal is yellow for one minute,
and then it is red for one minute.
Then the light is green again for three minutes, etc
*/

import java.io.*;

public class Semaforo {

	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		double min = Double.parseDouble(r.readLine())%5;
		System.out.println(min);
        if(min>=0 && min<3) setLight("green");
        else if(min>=3 && min<4) setLight("yellow");
        else if(min>=4 && min<5) setLight("red");
	}
	private static void setLight(String light) {
		System.out.println(light);
	}
}
