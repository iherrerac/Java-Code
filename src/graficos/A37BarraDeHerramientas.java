package graficos;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/*
 * Video 111
 * Modificamos el ejemplo A13 en vez de Botones , una barra de menus y una de herramientas
 * Agregamos una opcion mas para salir de la aplciacion instanciando AbstractAction de manera Anonima
 * Aplicacion que cambia el color de fondo ( Listener) desde
 * multiples fuentes ( Botones, combinacion de teclas)
 */

public class A37BarraDeHerramientas {

	public static void main(String[] args) {
		MiMarco37 m37 = new MiMarco37();
		m37.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

}

class MiMarco37 extends JFrame{
	
	public MiMarco37() {
		//setLayout(null);
		setTitle("Multiples Fuentes");
		setBounds(150, 100, 600,400);
		add(new MiPanel37());
		setVisible(true);
	}
}


class MiPanel37 extends JPanel{
	public MiPanel37() {
		setLayout(new BorderLayout());
		p37Norte = new JPanel();
		p37Norte.setLayout(new BorderLayout());
		add(p37Norte,BorderLayout.NORTH);
		initMenu();
	}
	
	
	private void initBotones() {
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
	
	private void initMenu() {
		String[] menuNombre = {"Color","Edicion"};
		JMenuBar menuBar = new JMenuBar();
		JToolBar menuHerraColor = new JToolBar();
		for (int j = 0; j < menuNombre.length; j++) {
			JMenu menu = new JMenu(menuNombre[j]);
			
			if (menuNombre[j].equals("Color")) {
				for (int i = 0; i < menuColorNombreItems.length; i++) {
					//Agregamos elementos JMenu( No JMenuItems) con el Action ColorFondoListener2
					menu.add(new ColorFondoListener2(menuColorNombreItems[i],new ImageIcon (menuColorRutaIconos[i]),setColorFondo[i]));
					//Contruimos la barra de herramientas
					menuHerraColor.add(new ColorFondoListener2(menuColorNombreItems[i],new ImageIcon (menuColorRutaIconos[i]),setColorFondo[i]));
				}
			}
			menuBar.add(menu);
		}
		
		//Vamos a crear la opcion en el menu de herramientas para salir de la aplicacion
		Action accionSalir = new AbstractAction("Salir",new ImageIcon("src/graficos/icono.jpg")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		//Agregamos un separador
		menuHerraColor.addSeparator();
		//Agregamos nueva opcion exit al menu
		menuHerraColor.add(accionSalir);
		//p37Norte.setJMenuBar(menuBar);
		p37Norte.add(menuBar,BorderLayout.NORTH);
		p37Norte.add(menuHerraColor,BorderLayout.CENTER);
		//add(menuBar,BorderLayout.NORTH);
		//TODO Si queremos que la barra pueda arrastrase, hay que indicarla BorderLAyout
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
	private int numBotones = 6;
	private JButton[] Botones= new JButton[numBotones];
	String[] menuColorNombreItems = {"azul","rojo","verde","blanco","negro","Rosa"};
	String[] menuColorRutaIconos = {"src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg","src/graficos/icono.jpg"};
	Color[] setColorFondo = {Color.BLUE,Color.RED,Color.GREEN,Color.WHITE,Color.BLACK,Color.PINK};
	JPanel p37Norte;
}


