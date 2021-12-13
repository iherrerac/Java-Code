package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;

public class A34Menus {

	public static void main(String[] args) {
		Marco34 m34 = new Marco34();
		m34.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Marco34 extends JFrame{
	public Marco34() {
		setTitle("Menus");
		setBounds(100,150,500,300);
		add(new Panel34());
		setVisible(true);
	}
}

class Panel34 extends JPanel{
	public Panel34() {
		setLayout(new BorderLayout());
		miArea = new JTextPane();
		menu= new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herramientas");
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar como");
		JMenuItem cortar = new JMenuItem("Cortar");
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem pegar = new JMenuItem("Pegar");
		JMenu opciones = new JMenu("Opciones");
		JMenuItem opcion1 = new JMenuItem("Opcion1");
		JMenuItem opcion2 = new JMenuItem("Opcion2");
		JMenuItem generales = new JMenuItem("Generales");
		archivo.add(guardar);
		archivo.add(guardarComo);
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator();//Separador
		edicion.add(opciones);
		opciones.add(opcion1);
		opciones.add(opcion2);
		herramientas.add(generales);
		menu.add(archivo);
		menu.add(edicion);
		menu.add(herramientas);
		add(menu,BorderLayout.NORTH);
		add(miArea,BorderLayout.CENTER);

	}
	private JMenuBar menu;
	private JTextPane miArea;
}