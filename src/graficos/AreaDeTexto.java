package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Declarar un campo de area con salto de pagina y barra de scroll 
 * la barra de scroll no se puede agregar directamente, se agrega a una lamina 
 */
public class AreaDeTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco23 m23 = new MiMarco23();
		m23.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MiMarco23 extends JFrame{
	public MiMarco23() {
		setTitle("Areas de Texto 1");
		setBounds(100,100,600,300);
		add(new MiPanel23());
		setVisible(true);
	}
}
class MiPanel23 extends JPanel{
	public MiPanel23 () {
	//constructor con 8x20 unidades
	JTextArea area= new JTextArea(8,20);
	// JScrollPaneles un p<nel
	JScrollPane laminaBarra = new JScrollPane(area);
	area.setLineWrap(true);//segun escribimos no se ensancha, incorpora un salto de linea
	//add(area);
	add(laminaBarra);
	JButton miBoton= new JButton("Consola");
	miBoton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(area.getText());
		}
	});
	add(miBoton);
	}
}