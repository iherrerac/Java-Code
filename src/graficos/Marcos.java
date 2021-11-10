package graficos;

import javax.swing.JFrame;//Marcos

public class Marcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marcos1 miMarco = new Marcos1();
		
		//Hacer visible
		miMarco.setVisible(true);
		//Comportamiento cuando cerramos el marco
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marcos1 extends JFrame{
	
	public Marcos1() {
		//Establece tamaño de la ventana
		setSize (500,300);
	}
}