package graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/*
 * Video 121,122
 * Aplicacion con 4 botones que cada una abre un Cuadro de Dialogo JOptionPane diferente
 */

public class A42VentanasEmergentesCuadrosDialogos {

	public static void main(String[] args) {
		Marco42 m42= new Marco42();
		m42.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco42 extends JFrame{
	public Marco42() {
		setTitle("Ventanas Emergente: Cuadros de Dialogo");
		setBounds(100,200,600,300);
		add(new Panel42());
		setVisible(true);
	}
	
}

class Panel42 extends JPanel{
	
	public Panel42 () {
		for (int i=0; i < botones.length;i++) {
			CreaBotones(botones[i]);
		}
	}
	
	public void CreaBotones(String nombre) {
		JButton boton = new JButton(nombre);
		boton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (boton.getActionCommand()) {
				case "Message Dialog":
					System.out.println("Has pulsado el boton 1");
					/*El primer parametro Panel42.this ( Componente padre) es la clase interna 
					que se encuentra en la lamina. el segundo parametro el mensaje:
						JOptionPane.showMessageDialog(Panel42.this, "mensaje de prueba");
						
					Otro constructo es (Componente padre, mensaje, Titulo, icono):
					El icono depende del OptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
					JOptionPane.WARNING_MESSAGE,JOptionPane.QUESTION_MESSAGE or JOptionPane.PLAIN_MESSAGE
						JOptionPane.showMessageDialog(Panel42.this, "mensaje de prueba", "Titulo", JOptionPane.WARNING_MESSAGE);
						
					Finalmente podemos establecer un Icono personalizado:*/
					JOptionPane.showMessageDialog(Panel42.this, "Mensaje de prueba", "Titulo", 0, new ImageIcon("src/graficos/iconos/warning.png"));
					break;
				case "Input Dialog":
					System.out.println("Has pulsado el boton 2");
					//Ventana de Entrada de datos
					//JOptionPane.showInputDialog("Introduce Nombre");
					JOptionPane.showInputDialog(Panel42.this, "mensaje de prueba", "Titulo", JOptionPane.QUESTION_MESSAGE);
					break;
				case "Confirm Dialog":
					System.out.println("Has pulsado el boton 3");
					/*Parecido a inputDialog, pero permite cambiar las opciones introducidas 
					por el usuario. Opciones del tipo de mensaje: JOptionPane.DEFAULT_OPTION,
					JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_CANCEL_OPTION or JOptionPane.OK_CANCEL_OPTION*/ 
					JOptionPane.showConfirmDialog(Panel42.this, "Elige opcion", "Titulo: Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
					break;
				case "Option Dialog":
					System.out.println("Has pulsado el boton 4");
					JOptionPane.showOptionDialog(Panel42.this, "Elige opcion", "Titulo: Option Dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/graficos/iconos/warning.png"), botones, e);
					break;

				default:
					break;
				}
			}
			
		});
		add(boton);
	}
	String[] botones = {"Message Dialog","Input Dialog","Confirm Dialog","Option Dialog"};
}
