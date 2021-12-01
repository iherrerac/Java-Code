package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import javax.swing.event.DocumentListener;

/*
 * Controlar eventos en campos de texto con interfaz Document y DocumentListener
 */

public class CamposDeTextoEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiMarco21 m21 = new MiMarco21();
		m21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MiMarco21 extends JFrame{
	public MiMarco21() {
		setTitle("Eventos campo de texto");
		setBounds(300,200,600,300);
		add(new MiPanel21());
		setVisible(true);
	}
}

class MiPanel21 extends JPanel{
	public MiPanel21() {
		/*
		 * DecInit campode texto, creamos objeto DocumentListener, creamos
		 */
		JTextField campo = new JTextField(20);//DecInit fuente campo de texto
		EscuchaTexto evento = new EscuchaTexto();//Creamos evento
		Document docu= campo.getDocument();//creamos objeto Document con getDocument del campo
		docu.addDocumentListener(evento);// Agregamos el documento como listener
		add(campo);
		
	}
}

class EscuchaTexto implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("inserta");
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("remove");
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
