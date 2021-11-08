package poo;

public class Arrays1_Bidimensional {

	public static void main(String[] args) {
		
		//Declarar e inicializar un Array bidimensional en la misma linea
		String[][] miArray = {{"Israel","Rocio","Dario","Candela"},
							 {"Herrera","Antona","Herrera","Herrera"}};
		
		//Recorrer array con bucle for mejorado
		for (String[] nombre : miArray) {
			System.out.println();
			for (String apellido: nombre) {
				 System.out.print(apellido + " ");
			}
		}
		
	
		//Declarar e initializar un Array BI indicando indices;
		int[][] miArray1 = new int[2][3];
		miArray1[0][0] = (int)Math.round(Math.random()*100);
		miArray1[0][1] = (int)Math.round(Math.random()*100);
		
		//Recorrer array con bucle for clasico
		for ( int i=0; i < miArray1.length; i++) {
			System.out.println();
			for ( int j=0; j < miArray1[0].length; j++) {
				miArray1[i][j] = (int)Math.round(Math.random()*100);
				System.out.print(miArray1[i][j]+" ");
			}
		}

		//Inicializar e imprimir miArray
		

	}
}
