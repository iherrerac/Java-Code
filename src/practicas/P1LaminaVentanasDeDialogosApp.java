package practicas;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class P1LaminaVentanasDeDialogosApp extends JPanel{
	public P1LaminaVentanasDeDialogosApp(String titulo,String[] opciones) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo));
		setVisible(true);
		grupo = new ButtonGroup();
		for(int i=0;i< opciones.length;i++) {
			JRadioButton bot = new JRadioButton(opciones[i]);
			add(bot);
			//Indicamos el ActionCommand
			bot.setActionCommand(opciones[i]);
			grupo.add(bot);
			bot.setSelected(i==0);//si i==0 selecciona la primera opcion
		}
	}

	public String  dameSeleccion() {
		//almacenamos el JRadioButton que tenemos seleccionado
		ButtonModel miBoton = grupo.getSelection();
		//Devolver el String de la accion de comando
		return miBoton.getActionCommand();
	}
	
	private ButtonGroup grupo;
}
