package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;

/*
 * Aplicacion que captura una tecla y nos indica su codigo, caracter
 * mediante interfaz KeyListener y tambien implementamos desde clase Adaptadora
 */
public class EventosTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco9 M9 = new Marco9();
		M9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Marco9 extends JFrame{
	public Marco9() {
		setVisible(true);
		setBounds (400,200,300,200);
		//Creamos el objeto evento de teclado y se lo pasamos al Listener
		EventoDeTeclado t1 = new EventoDeTeclado();
		EventoDeTeclado2 t2 = new EventoDeTeclado2();
		addKeyListener(t1);
		addKeyListener(t2);
	}
}

//Evento de teclado implementando la interface Keylistener
class EventoDeTeclado implements KeyListener{

	@Override
	// Al pulsar
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char letra = e.getKeyChar();
		System.out.println(letra);		
	}

	@Override
	//al presionar
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigo = e.getKeyCode();
		System.out.println(codigo);		
	}

	@Override
	//al levantar el dedo de la tecla
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

//Desde clase Adaptadora, solo implementamos los metodos que necesitemos
class EventoDeTeclado2 extends KeyAdapter{
	
	public void keyTyped(KeyEvent e) {
		char letra = e.getKeyChar();
		System.out.println("Desde clase Adaptadora: " + letra);		
	}
	
}