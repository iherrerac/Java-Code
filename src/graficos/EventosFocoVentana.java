package graficos;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/*
 * Aplicacion que cambia el titulo de la ventana que tiene el foco
 */

public class EventosFocoVentana extends JFrame implements WindowFocusListener{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventosFocoVentana M12 = new EventosFocoVentana(200,100);
		EventosFocoVentana M13 = new EventosFocoVentana(650,100);
	}
	
	// Constructor, paso los parametros x e y
	public EventosFocoVentana(int x,int y) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(x,y,400,300);
		addWindowFocusListener(this);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		//	if (e.getSource()==M12) System.out.println("M12");
		// He prescindido del if
		setTitle("Tengo el foco ¡¡");

		}
	

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		setTitle("He perdido el foco ¡¡");
	}
}
