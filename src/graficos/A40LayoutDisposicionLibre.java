package graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

/*
 * Video 118
 * Creamos una lamina disposición libre
 */

public class A40LayoutDisposicionLibre {

	public static void main(String[] args) {
		Marco40 m40 = new Marco40();
		m40.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco40 extends JFrame{
	public Marco40 () {
		setTitle("Layout Disposicion libre");
		setBounds(100,200,600,300);
		add(new Panel40());
		setVisible(true);
	}
}
class Panel40 extends JPanel{
	public Panel40 () {
		setLayout(null);//Disposicion libre o layout nulo
		JButton boton1= new JButton("Boton 1");
		boton1.setBounds(30,50,120,30);//Ubicar el boton, no vale otro medoo mas que setBounds
		add(boton1);
		
		JButton boton2= new JButton("Boton 2");
		boton2.setBounds(170,50,120,30);//Ubicar el boton, no vale otro medoo mas que setBounds
		add(boton2);
		
		CreaEtiquetayCampo("Nombre: ",30,100,150,30);
		CreaEtiquetayCampo("Apellido: ",30,150,150,30);
	}
	public void CreaEtiquetayCampo(String nombre, int x, int y, int width, int height) {
		JLabel etiqueta = new JLabel(nombre);
		JTextField campo = new JTextField();//Si trabajamos con setBounds no es necesario establecer el tamaño del TextField
		etiqueta.setBounds(x,y,width-40,height);
		campo.setBounds((x+width-40),y,width,height);
		add(etiqueta);
		add(campo);
	}
}