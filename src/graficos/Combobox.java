package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Declarar un ComboBox
 */

public class Combobox {

	public static void main(String[] args) {
		Marco29 m29 = new Marco29();
		m29.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Marco29 extends JFrame{
	public Marco29() {
		setTitle("ComboBox 1");
		setBounds(100,150,600,300);
		add(new Panel29());
		setVisible(true);
	}
}
class Panel29 extends JPanel{
	public Panel29() {
		setLayout(new BorderLayout());
		texto= new JLabel("En un lugar de la mancha de cuyo nombre ...");
		texto.setFont(new Font ("Serif", Font.PLAIN,14));
		add(texto,BorderLayout.CENTER);
		
		JPanel laminaNorte = new JPanel();
		
		miCombo= new JComboBox();
		miCombo.addItem("Serif");
		miCombo.addItem("SansSerif");
		miCombo.addItem("Monospaced");
		miCombo.addItem("Dialog");
		miCombo.setEditable(true);//permitir que se escriba en el combo	
		EventoCombo evento = new EventoCombo();
		miCombo.addActionListener(evento);
		laminaNorte.add(miCombo);
		add(laminaNorte,BorderLayout.NORTH);
		
	}
	private class EventoCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			texto.setFont(new Font(miCombo.getSelectedItem().toString(),Font.PLAIN,18));//
		}
		
	}
	private JLabel texto;
	private JComboBox miCombo;
}
