package graficos;



import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;


public class MiMarcox {

	public static void main(String[] args) {

		Marc Ventana = new Marc();
	}
}

class Marc extends JFrame{
	public Marc() {
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Cromix Incoming ¡¡¡");
	Toolkit MiPantalla = Toolkit.getDefaultToolkit();
	Dimension MiResolucion = MiPantalla.getScreenSize();
	setBounds (MiResolucion.width/4,MiResolucion.height/4,MiResolucion.height/2,MiResolucion.height/2);
	Image MiIcono = MiPantalla.getImage("src/graficos/cromixicono.jpg");
	setIconImage(MiIcono);
	 //Botón
    JButton boton1=new JButton("Alta");
    boton1.setBounds(300,250,100,30);
    add(boton1);
    ActionListener oyente = new Listener();
    boton1.addActionListener(oyente);
    setVisible(true); //Al final para que lo pinto todo OK
	}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
}


