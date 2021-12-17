package graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/*
 * Video 119,120
 * Disposicion libre
 * Crear una clase que sea capaz de colocar los componentes como tu deseas.
 * Para ello debe implementar la interfaz LaoyoutManager
 * Creamos una clase que coloca los componentes en pareja y los centra en el contenedor
 */

public class A41LayoutLibreCreacionPropia {

	public static void main(String[] args) {
		Marco41 m41 = new Marco41();
		m41.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Marco41 extends JFrame{
	public Marco41() {
		setTitle("Disposicion Libre");
		setBounds(100,200,600,300);
		add(new Panel41());
		setVisible(true);
	}
}

class Panel41 extends JPanel{
	public Panel41() {
		setLayout(new EnColumnas());
		CreaEtiquetayCampo("Nombre: ");
		CreaEtiquetayCampo("Apellido: ");
		CreaEtiquetayCampo("Edad: ");
		CreaEtiquetayCampo("Domicilio: ");
	}
	
	public void CreaEtiquetayCampo(String nombre) {
		JLabel etiqueta = new JLabel(nombre);
		JTextField campo = new JTextField();//Si trabajamos con setBounds no es necesario establecer el tamaño del TextField
		add(etiqueta);
		add(campo);
	}
}
class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return null;
	}

	@Override
	public void layoutContainer(Container miContenedor) {
		int anchoContenedor=miContenedor.getWidth();//Dimensiones del contenedor
		x=anchoContenedor/2; //Punto central del contenedor
		int contadorElementos=0;
		int numeroDeComponentes=miContenedor.getComponentCount();//Cuandos componentes hay en mi contenedor
		for(int i = 0; i < numeroDeComponentes; i++) {
			contadorElementos++;
			Component componente= miContenedor.getComponent(i);//Conseguimos el elemento que sea ( Jbutton, JtextField, etc)
			componente.setBounds(x-100,y,100,20);//El primer elemento x-100 para que lo coloque a la derecha del centro
			x+=100;//Ponemos el siguiente componente 100 pxl a la derecha
			//Incrementar la Y cada vez que contador sea par, usando residuo (si la division es par residio da 0)
			if(contadorElementos%2==0) {
				x=anchoContenedor/2;
				y+=40;
			}
		}
	}
	
	private int x;
	private int y=20;
			
}