package programacionGenerica;

/*
 * Usa la claseGenerica que hemos fabricado
 * Video 165
 */

public class UsoClaseGenerica {

	public static void main(String[] args) {
		ClaseGenerica<String> una = new ClaseGenerica<String>();
		una.setPrimero("Juan");
		System.out.println(una.getPrimero());
		
		ClaseGenerica<Persona> unaPersona = new ClaseGenerica<Persona>();
		unaPersona.setPrimero(new Persona ("Ana"));
		System.out.println(unaPersona.getPrimero().toString());
	}

}


class Persona{
	public Persona(String nombre) {
		this.nombre= nombre;
	}
	
	//Sobrescribimos metodo toString
	public String toString() {
		return nombre;
	}
	
	private String nombre;
}
