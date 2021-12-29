package excepciones;

import javax.swing.JOptionPane;

//Excepciones Video 142,143,144.145,146

public class Fallos {

	public static void main(String[] args) {
		int [] mi_matriz= new int[5];
		mi_matriz[0] = 5;
		mi_matriz[1] =38;
		mi_matriz[2] =-15;
		mi_matriz[3] =92;
		mi_matriz[4] =71; 
		
		for (int i = 0; i < mi_matriz.length; i++) {
			System.out.println("Posicion: " + i + " =" + mi_matriz[i]);
		}
		
		//Peticion datos personales
		String nombre = JOptionPane.showInputDialog("Introduce nombre");
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Introduce edad"));
		System.out.println("Hola "+ nombre + " Tienes " + edad + " años."+"FIN");
	}

}
