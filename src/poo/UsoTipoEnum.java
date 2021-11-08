package poo;

public class UsoTipoEnum {
	/*
	 * Un objeto tipo enum permiten almacenar un grupo de valores y solo ese grupo de valores.
	 * No podemos declarar nunca un enum dentro del main.
	 */
	
	enum Talla{MINI,MEDIANO,GRANDE,MUYGRANDE};
	
	public static void main (String[] args) {
		
		Talla s = Talla.MINI;
		Talla m = Talla.MEDIANO;
		Talla l = Talla.GRANDE;
		Talla xl = Talla.MUYGRANDE;
		
		
	}

}
