package graficos;

import javax.swing.JFrame;//VEntanas
import java.awt.Toolkit; // Sistema operativo
import java.awt.Dimension; // Resolucion pantalla

public class Marcos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado MiMarco = new MarcoCentrado();
	}
}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//Objeto Toolkit con datos del sistema
	Toolkit MiPantalla = Toolkit.getDefaultToolkit();
	//Metodo del objeto Toolkit para obtener la resolución
	Dimension MiResolucion = MiPantalla.getScreenSize();
	int alturaPantalla = MiResolucion.height;
	int anchoPantalla = MiResolucion.width;
	setBounds(50,100,alturaPantalla/2,anchoPantalla/2);
	
	
	}
	
}