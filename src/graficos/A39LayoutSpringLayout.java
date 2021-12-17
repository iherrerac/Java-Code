package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/*
 * Video 116,117
 * Un marco con 3 Botones con muelles entre ellos
 * Agregamos tb un muelle rigido entre los botones
 */

public class A39LayoutSpringLayout {

	public static void main(String[] args) {
		Marco39 m39 = new Marco39();
		m39.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco39 extends JFrame{
	public Marco39 () {
		setTitle("Disposicion avanzada en muelle Spring Layout");
		setBounds(300,400,1000,350);
		add(new Panel39());
		setVisible(true);
	}
}

class Panel39 extends JPanel{
	public Panel39() {
		//Botones
		JButton boton1 = new JButton("Boton 1");
		JButton boton2 = new JButton("Boton 2");
		JButton boton3 = new JButton("Boton 3");
		
		//Creamos el SpringLayout y le decimos a la lamina que lo aplique
		SpringLayout miSpring = new SpringLayout();
		setLayout(miSpring);
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		//Creamos solo 1 muelle. si no los creeamos pone un boton encima de otro
		Spring muelle = Spring.constant(0, 10, 100);//Los parametros no estan claros
		//Agregamos muelle rigido entre botones, para que al redimensionar no cambie la
		//distancia entre botones
		Spring muelleRigido = Spring.constant(10);//Un solo parametro, muelle rigido, ancho del muelle
	
				
		//Colocamos el muelle, hay que colocarlos en los extremos de los componentes
		//EL muelle une border WEST del boton1 con el borde WEST de la lamina (this)
		miSpring.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
		miSpring.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);
		miSpring.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);
		miSpring.putConstraint(SpringLayout.EAST, this, muelle, SpringLayout.EAST, boton3);
	}
}
