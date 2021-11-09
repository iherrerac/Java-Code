package poo;

public class Interfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jefatura jefe1 = new Jefatura("Juan", 30000);
		System.out.println("El Jefe: "+jefe1.nombre+" tiene un sueldo de: "+(jefe1.sueldo+jefe1.estableceBonus(2000.00)));
	}

}

//Declaro la interfaz. Pueden ser public o default
interface Jefes {
	//todos los metodos son public y abstrac, puede obviarse por convencion
	//Los metodos solo se definen, no se desarrollan 
	double estableceBonus(double gratificacion);
	//las variable son public static y final, se puede omitir los modificadores
	double bonusBase=2000;
}

class Jefatura implements Jefes{
	public Jefatura(String nom, double sue){//CONSTRUCTOR
		sueldo = sue;
		nombre = nom;
	}
	@Override
	//Override metodo Jefes
	public double estableceBonus(double gratificacion) {
		return Jefes.bonusBase+gratificacion;
	}
	String nombre;
	double sueldo;
}
