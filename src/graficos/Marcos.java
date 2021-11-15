package graficos;

import javax.swing.JFrame;//Marcos

public class Marcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marcosx miMarco = new Marcosx();
		
		//Hacer visible
		miMarco.setVisible(true);
		//Comportamiento cuando cerramos el marco
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marcosx extends JFrame{
	
	public Marcosx() {
		
		//(x,y,ancho,largo)
		setBounds (30,100,500,300);
		//Titulo
		setTitle ("Mi ventana");
		//No se puede redimensionar, 
		setResizable (false);
		// Aparece maximizado o no en pantalla activo o inactivo
		//setExtendedState(JFrame.MAXIMIZAD_BOTH);
		
	}
}