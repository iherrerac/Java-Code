package graficos;

import javax.swing.JFrame;
import java.awt.Frame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*
 * Aplicacion que marca el estado de la ventana
 */

public class EventosVentana {

	public static void main(String[] args) {
		MiMarco8 M8 = new MiMarco8();
		MiMarco8 M9 = new MiMarco8();
		
		M8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		M8.setTitle("Ventana1");
		M9.setTitle("Ventana2");
		M8.setBounds(400,200,300,200);
		M9.setBounds(800,200,300,200);
		
	}

}

class MiMarco8 extends JFrame{
	public MiMarco8() {
		setVisible(true);
		add(new MiPanel8());
		addWindowListener(new ListenerVentana());
		addWindowStateListener(new ListenerVentana());
	}
}

class MiPanel8 extends JPanel{
	
}

class ListenerVentana extends WindowAdapter{
	
	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana Activada");	
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana Desactivada");	
	}
	public void windowIconified(WindowEvent e){
		System.out.println("Ventana Minimizada");	
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("Ventana estado Normal");	
	}
	//Controla Tambien el Cambio de estado
	public void windowStateChanged(WindowEvent e) {
		System.out.println("La ventana ha cambiado de estado");
		if (e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("Ventana Maximizada");
		}else if (e.getNewState()==Frame.ICONIFIED) {
			System.out.println("Ventana Minimizada");
		}
	}
}