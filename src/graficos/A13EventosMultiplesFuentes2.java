package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.AbstractAction;
import java.awt.Color;

/*
 * Aplicacion que cambia el color de fondo ( Listener) desde
 * multiples fuentes ( Botones, combinacion de teclas)
 */

public class A13EventosMultiplesFuentes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MiMarco14 M13 = new MiMarco14();
		M13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

}

class MiMarco14 extends JFrame{
	
	public MiMarco14() {
		//setLayout(null);
		setVisible(true);
		setTitle("Multiples Fuentes");
		setBounds(150, 100, 600,400);
		add(new MiPanel14());
	}
}


class MiPanel14 extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);
		initBotones();
		initListener();
	}
	

	
	private void initBotones() {
	
	}
	
	private void initListener() {
		//Array Posiciones Botones
		int[] setXBotones = {30,30,30,30,30,30};
		int[] setYBotones = {30,80,130,180,230,280};
		
		//Array  Datos para constructor AbstracAction
		String[] setNombreBoton = {"azul","rojo","verde","blanco","negro","Rosa"};
		String[] rutaIconoBoton = {"src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg"};
		Color[] setColorFondo = {Color.BLUE,Color.RED,Color.GREEN,Color.WHITE,Color.BLACK,Color.PINK};
		
		//declaramos Array Objeto Action
		ColorFondoListener2[] ArrayObjetosAction= new ColorFondoListener2[numBotones]; 
		
		for ( int i=0; i<Botones.length;i++) {
			//Inicializamos Array Objeto Action
			ArrayObjetosAction[i]= new ColorFondoListener2(setNombreBoton[i],new ImageIcon (rutaIconoBoton[i]),setColorFondo[i]);
			//InputMap Vincula un evento con una combinacion de teclas
			//getInputMap indicamos con JComponent el componente que recibe la accion
			//Constante de clase: Indica que el objeto que va a recibir el foco ( el boton)
			// es algo que esta dentro la ventana.
			
			InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			//Inicializar la combinacion de teclas con KeyStroke
			//Modificadores de getKeyStroke shift, control,ctrl,meta,alt,altGraph
			KeyStroke TeclaAzul = KeyStroke.getKeyStroke("ctrl A");
			//Vincular la combinacion de teclas con el Objeto que lleva a cabo la accion
			//Metodo put de InputMap , objeto que asociaremos a la accion
			mapaEntrada.put(TeclaAzul,"Cambiarcolorfondoazul");
			mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"),"Cambiarcolorfondorojo");
			//crear un mapadeaction para porteriormente usar el metodo put de la clase ActionMap
			ActionMap mapaAccion=getActionMap();
			//Vincular  el objeto creado anteriormente la accion en si misma
			mapaAccion.put("Cambiarcolorfondoazul",ArrayObjetosAction[0]);
			mapaAccion.put("Cambiarcolorfondorojo",ArrayObjetosAction[1]);
			
			Botones[i]= new JButton(ArrayObjetosAction[i]);//Llamamos a JButton con el metodo JButton(Action a)
			Botones[i].addActionListener(new ColorFondoListener2(setNombreBoton[i],new ImageIcon (rutaIconoBoton[i]),setColorFondo[i]));
			Botones[i].setBounds(setXBotones[i],setYBotones[i],140,30);
			add(Botones[i]);
		}
	}

	
	/*
	 * Controlar multiples fuentes con Interface Action 
	 * o bien como una clase similar a clase adaptadora llamada AbstracAction.
	 * Vamos a agregar nombre del boton, icono del boton, descripcion, accion al objeto event
	 */
	class ColorFondoListener2 extends AbstractAction{
		

		public ColorFondoListener2(String nombre,Icon icono, Color c) {
			/*
			 * Interfaz action implementa un objeto clave:valor. Tenemos una constante action
			 * clave(nombre):Valor(azul,rojo,etc). Lo mismo para icono, descripcion o un campo
			 * que creemos nosotros.
			 */
						
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION,"Poner la lamina de color: "+nombre);
			putValue("Color_de_fondo", c);
		
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c= (Color)getValue("Color_de_fondo");
			setBackground(c);
		}
	}
	int numBotones = 6;
	JButton[] Botones= new JButton[numBotones];

}


