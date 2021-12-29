package graficos;

public class Array3Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Una hoja excel donde vamos acumulando el 10%, 11%,12%,13% y 14% de saldo anualmente
		// Video 26 de pildoras informaticas
		
		
		double acumulado;
		double interes = 0.10; // 10% de interes
		
		double[][] saldo= new double[6][5];
		
		for (int i=0; i< saldo.length; i++) {
			saldo[i][0] = 10000;
			acumulado= 10000;
			System.out.println();
			System.out.printf("%1.2f",saldo[i][0]);
			System.out.print(" ");
			for(int j=1	; j<saldo[0].length; j++) {
				acumulado+=acumulado*interes;
				saldo[i][j] = acumulado;
				System.out.printf("%1.2f",saldo[i][j]);
				System.out.print(" ");
			}
			interes+=0.01;
		}
	}

}
