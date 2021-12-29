package graficos;
import java.beans.DefaultPersistenceDelegate;

public class Arrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arrays bidimensionales: Generar un array BI de numeros aleatorios
		
		int[][] matrix = new int[2][3];
		// Como obtenemos el length de las dos dimensiones? así:
		System.out.println("Dimesiones: "+matrix.length+" , "+matrix[0].length);
		
		//Inicializar e imprimir matrix
		for ( int i=0; i < matrix.length; i++) {
			System.out.println();
			for ( int j=0; j < matrix[0].length; j++) {
				matrix[i][j] = (int)Math.round(Math.random()*100);
				System.out.print(matrix[i][j]+" ");
			}
		}
		
		// Imprimir el array con foreach
		for (int[] elemento : matrix) {
			System.out.println();
			for (int z: elemento) {
				 System.out.print(z + " ");
			}
			
		}
	
	}

}
