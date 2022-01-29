package codegymejemplos;

import java.time.LocalDate;

public class FechaHoy {
    public static void main(String[] args) {
        LocalDate todaysDate = LocalDate.now();
        String s=todaysDate.toString();
        System.out.println(s);
        System.out.println(""+s.charAt(5)+s.charAt(6)+" "+s.charAt(8)+s.charAt(9)+" "+s.charAt(0)+s.charAt(1)+s.charAt(2)+s.charAt(3));
    }
}