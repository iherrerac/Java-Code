package poo;
//Videos 52/53

import javax.swing.JOptionPane;
import javax.swing.Timer; //Libreria para el temporizador
import java.awt.event.*; //Libreria para la interface ActionListener  
import java.util.Date; //Libreria para el tipo Date
import java.awt.Toolkit;//Caracteristicas windows

public class Temporizador {

	public static void main(String[] args) {
		// Mensaje en consola con la hora cada 5 segundos
		
		//Objeto tipo DamelaHora que implementa la interfaz ActionListener
		//Tambien se puede instanciar así: ActionListener oyente= new DameLaHora();
		DameLaHora oyente = new DameLaHora();
		
		//Timer(int delay, interface Actionlistener)
		//Nos obliga a pasar ActionListener para invocar el metodo actionPerformed obligatoriamente
		Timer miTemporizador = new Timer(5000, oyente);
		miTemporizador.start();//Comienza el temporizador
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		System.exit(0);
		
	}
}

class DameLaHora implements ActionListener{
	//ActionListener implementa un metodo actionPerformed(Accion a realizar)
	//Queremos que el temporizador devuelva la hora cada 5 segundos
	public void actionPerformed (ActionEvent e) {
		//hora actual
		Date ahora= new Date();
		System.out.println("Te pongo la hora cada 5 segundos: "+ ahora);
		Toolkit.getDefaultToolkit().beep(); //sonido Windows
	}
}
