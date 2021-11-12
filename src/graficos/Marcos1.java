package graficos;

import javax.swing.JFrame;//Ventanas
import java.awt.Toolkit; // Sistema operativo
import java.awt.Dimension; // Resolucion pantalla
import java.awt.Image; // Clase para tratar imagenes

public class Marcos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado MiMarco = new MarcoCentrado();
	}
}

class MarcoCentrado extends JFrame{
	//Constructor
	public MarcoCentrado() {
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Mi marco centrado.");
		
	//Objeto Toolkit con datos del sistema
	Toolkit MiPantalla = Toolkit.getDefaultToolkit();
	//Metodo del objeto Toolkit para obtener la resolución
	//Creamos una ventana centrada (posicion /4) y tamaño /2 de la resolucion.
	Dimension MiResolucion = MiPantalla.getScreenSize();
	int alturaPantalla = MiResolucion.height;
	int anchoPantalla = MiResolucion.width;
	setBounds(anchoPantalla/4,alturaPantalla/4,anchoPantalla/2,alturaPantalla/2);
	Image MiIcono = MiPantalla.getImage("src/graficos/icono.jpg");
	setIconImage(MiIcono);

	
	
	}
	
}