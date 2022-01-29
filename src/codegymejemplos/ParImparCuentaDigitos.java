package codegymejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParImparCuentaDigitos {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(r.readLine());
        int cont=0;
        if (number>=0){
            while(!(number/10 == 0)){
                if((number-(number/10)*10)%2 == 0) even++;
                else odd++;
                number = number/10;
            }
            if (number%2 == 0) even++;
            else odd++;
            System.out.printf("Even: %d Odd: %d",even,odd);
        }
    }
}
