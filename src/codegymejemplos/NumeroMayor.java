package codegymejemplos;

/* 
Maximum of four numbers

*/

import java.io.*;

public class NumeroMayor {
    public static void main(String[] args) throws Exception {
        int[]arrNums = new int[4];
        for (int i = 0; i < arrNums.length ; i++){
            BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
            arrNums[i] = Integer.parseInt(s.readLine());
        }
        int numMayor= arrNums[0];
        for (int i = 1; i < arrNums.length ; i++){
            //System.out.print(numMayor);
            if(arrNums[i] >numMayor) numMayor = arrNums[i];
        }
        System.out.print(numMayor);
    }
}