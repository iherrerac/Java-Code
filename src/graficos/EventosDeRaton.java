package graficos;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

/*
 * Aplicacion que indica por consola cuando se ha hecho click en el marco y otros eventos de MouseListener
 * Tambien desde Clase Adaptadora
 */

public class EventosDeRaton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco10 M10 = new MiMarco10();
		M10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco10 extends JFrame{
	public MiMarco10() {
		setVisible(true);
		setBounds(400,200,600,400);
		//Instanciamos en el marco el Listener que es la fUente de nuestro evento
		EventoDeRaton Raton1 = new EventoDeRaton();
		EventoDeRaton2 Raton2 = new EventoDeRaton2();
		addMouseListener(Raton1);
		addMouseListener(Raton2);
	}
}

class EventoDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Haz hecho click.");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Haz pulsado el boton del raton.");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Haz liberado el boton del raton.");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}

class EventoDeRaton2 extends MouseAdapter{
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Entraste en el Marco (Desde Clase Adaptadora)");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Saliste del Marco (Desde Clase Adaptadora)");
	}
	
}