
package poo;//Paquete = Carpeta
import javax.swing.JOptionPane; //Entrada tipo ventana
import java.util.Scanner; // Entrada por consola
import java.util.Date;// Fecha tipo Date y metodo .getTime
import java.util.GregorianCalendar; //Objeto new GregorianCalendar(agno, mes-1,dia);

public class Clase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clase miClase = new Clase("Israel");//Instanciamos objeto
	}
	
	public Clase(String nombre){ //Constructor: Mismo nombre que clase
		this.nombre= nombre;
	}
	public Clase(String nom,String apellidos) {//Constructor2:Sobrecarga
		this(nom);//llamada al constructor predeterminado, debe ir lo primero 
		this.apellido =apellidos;		
	}
	
	public String dameNombre(){//GETTER
		return "Mi nombre es "+nombre;
	}
	
	public void dimeNombre(String nombre) {//SETTER
		this.nombre = nombre;
	}
	
	private String nombre;// Encapsulamiento
	private String apellido;// Encapsulamiento
}
