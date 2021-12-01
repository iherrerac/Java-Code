package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CasillaDeVerificacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco25 m25 = new Marco25();
		m25.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco25 extends JFrame{
	public Marco25 () {
		setTitle("Casilla de Verificacion");
		setBounds(200,200,500,300);
		add(new Panel25());
		setVisible(true);
	}
}

class Panel25 extends JPanel{
	public Panel25() {
		setLayout(new BorderLayout());
		Font miletra = new Font("Serif", Font.PLAIN,24);
		texto= new JLabel("En un lugar de la mancha de cuyo nombre...");
		texto.setFont(miletra);//Objeto por parametro de tipo Font
		JPanel miLamina= new JPanel();
		miLamina.add(texto);
		add(miLamina,BorderLayout.NORTH);
		check1 = new JCheckBox("Negrita");
		check2= new JCheckBox("Cursiva");
		check1.addActionListener(new ManejaCheck());
		check2.addActionListener(new ManejaCheck());
		JPanel miLamina2 = new JPanel();
		miLamina2.add(check1);
		miLamina2.add(check2);
		add(miLamina2,BorderLayout.SOUTH);
	}
	class ManejaCheck implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int tipoLetra=0; 
			// Sumamos un int segund el valor de la casilla marcada
			if (check1.isSelected()) tipoLetra+= Font.BOLD;//negrita es valor 1
			if (check2.isSelected()) tipoLetra+= Font.ITALIC;//cursiva es valor 2
			texto.setFont(new Font("Serif",tipoLetra,24));
		}
		
	}
	private JLabel texto;
	private JCheckBox check1,check2;
}
