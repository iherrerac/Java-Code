package poo;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterLocation;
 
public class UsoTipoEnum2 {
	/*
	 * Un objeto tipo enum permiten almacenar un grupo de valores y solo ese grupo de valores.
	 * No podemos declarar nunca un enum dentro del main.
	 * Enum no admiten la creacion de objetos, no podemos invocar el constructor desde una instancia, 
	 * por lo que el constructor lo construimos como private 
	 */
	
	enum Talla{
		//declaramos los valores que admite en funcion del constructor
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUYGRANDE("XL");
		
		//Constructor funcionando a modo de Setter, 
		//asignando a los valores declarados arriba las abreviaturas.
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {//Getter devuelve la talla
			return this.abreviatura;
		}
		private String abreviatura;
	};
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce talla (MINI/MEDIANO/GRANDE/MUYGRANDE)");
		String entrada = sc.next().toUpperCase();
		
		//Creamos un objeto tipo talla y con valueof nos devuelve la constante
		//Enum.valueof(EnumType,name) enumtype: La clase objeto de tipo enum (MINI, MEDIANO, ETC)
		Talla laTalla = Enum.valueOf(Talla.class, entrada);
		System.out.println("Talla: "+ laTalla);
		System.out.println("Abreviatura: "+ laTalla.abreviatura);
		
	}

}
