package serializacion;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;


/*
 * Video 157,158
 * Serializacion de objetos (Convertir a sucesion de bytes para IO)
 * ToString para descripcion de los objectos de una clase.
 * 
 * serialVersionUID Cuando hacemos cambio en el programa la serializacion no es viable si 
 * no esta distribuido enre todos los emisores receptores el codigo cambiado. serialVersionUID.
 */

public class Serializando {

	public static void main(String[] args) {
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		jefe.setIncentivo(5000);
		
		Empleado[] personal= new Empleado[3];
		personal[0]= jefe;
		personal[1] = new Empleado("Ana",25000,2008,10,1);
		personal[2] = new Empleado("Luis",18000,2012,9,15);
		
		try {
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("C:/Users/casa/Desktop/empleado.dat"));
			escribiendoFichero.writeObject(personal);
			escribiendoFichero.close();
			ObjectInputStream recuperaFichero = new ObjectInputStream(new FileInputStream ("C:/Users/casa/Desktop/empleado.dat"));
			//readObject devuelve un object, por lo que hay que hacer casting 
			Empleado[] personalRecupera = (Empleado[])recuperaFichero.readObject(); 
			recuperaFichero.close();
			
			for (Empleado e: personalRecupera) {//for each
				System.out.println(e);
				
			}
		}catch(Exception e) {
			System.out.println("Problema creacion fichero");
		}
	}

}

class Empleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Empleado(String n, double s, int agno, int mes, int dia) {
		nombre = n;
		sueldo= s;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		fechaContrato= calendario.getTime();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Double getSueldo() {
		return sueldo;
	}
	
	public Date getFechaContrato() {
		return fechaContrato;
	}
	
	public void subirSueldo(double porcentaje) {
		double aumento= sueldo*porcentaje/100;
		sueldo +=aumento;
	}
	
	//Sobrescribir
	//ToString es que es lo que hace nuestra clase, descripcion de la clase
	public String toString() {
		return "Nombre: "+ nombre+" Sueldo: "+sueldo+" Fecha de contrato: "+fechaContrato;
	}
	
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
}

class Administrador extends Empleado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador (String n, double s, int agno, int mes, int dia) {
		super (n,s,agno,mes,dia);
		incentivo=0;
	}
	
	public double getsueldo() {
		double sueldoBase=super.getSueldo();
		return sueldoBase+incentivo;
	}
	
	public void setIncentivo(double b) {
		incentivo=b;
	}
	//Sobrescribir
	public String toString() {
		return super.toString()+" Incentivo: "+incentivo;
	}
	
	private double incentivo;
}
