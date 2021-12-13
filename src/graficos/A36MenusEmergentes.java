package graficos;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

/*
 * Menus emergentes con JPopupMenu al click derecho sobre la lamina
 */

public class A36MenusEmergentes {

	public static void main(String[] args) {
		Marco36 m36 = new Marco36();
		m36.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class Marco36 extends JFrame{
	public Marco36() {
		setTitle("Menus emergentes");
		setBounds(100,150,600,300);
		add(new Panel36());
		setVisible(true);
	}
}
class Panel36 extends JPanel{
	public Panel36() {
		setLayout(new BorderLayout());
		p36Norte= new JPanel();
		//p36Central= new JPanel();
		add(p36Norte,BorderLayout.NORTH);
		miArea= new JTextPane();
		add(miArea,BorderLayout.CENTER);
		//add(p36Central,BorderLayout.CENTER);
		menuEmer = new JPopupMenu();
		barra= new JMenuBar();
		p36Norte.add(barra);
		menu();
		menuEmergente();
	}
	
	//Crear el menu
	public void menu() {
		for (int i = 0; i < textoMenu.length; i++) {
			JMenu menuPrincipal= new JMenu(textoMenu[i]);
			barra.add(menuPrincipal);
		}
	}
	
	//Menu Emergente
	public void menuEmergente() {
		
		for (int i = 0; i < textoMEmergente.length; i++) {
			menuEmer.add(new JMenuItem(textoMEmergente[i]));
		}
		
		// Indicamos que queremos que el menu salga sobre la lamina. 
		// como estamos en el constructor de la lamina, solo llamamos 
		// al metodo heredado de PopupMenu
		miArea.setComponentPopupMenu(menuEmer);
		//add(menuEmer);
	}
	
	private JPopupMenu menuEmer;
	private String[] textoMEmergente= {"Opcion1","Opcion2","Opcion3"};
	private String[] textoMenu= {"Fuente","Estilo","Tamaño"};
	private JPanel p36Norte;
	private JMenuBar barra;
	//private JPanel p36Central;
	private JTextPane miArea;
	
	
}
