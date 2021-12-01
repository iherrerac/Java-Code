package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Layout4Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCalculadora mcalc = new MarcoCalculadora();
		mcalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCalculadora extends JFrame{
	public MarcoCalculadora() {
		setVisible(true);
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora lcalc = new LaminaCalculadora();
		add(lcalc);
		//Con pack se adapta al tamaño por defecto de lo que hay en su interior
		//pack();
	}
}

class LaminaCalculadora extends JPanel{
	public LaminaCalculadora() {
		principio=true;
		setLayout(new BorderLayout());
		//Usamos para el display un boton
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla,BorderLayout.NORTH);
		
		// Creamos segunda lamina instanciando la clase en vez de creando una clas que herede
		//y la agregamos indicandole la posicion dentro de laminaCalculadora
		laminaBotonera = new JPanel();
		laminaBotonera.setLayout(new GridLayout(5,4));
		add(laminaBotonera,BorderLayout.CENTER);
		
		String[] botones= {"7","8","9","/","4","5","6","*","1","2","3","-","C","0",".","+","="};
		String[] botonesNoNumericosString= {"/","*","-","C",".","+","="};
		
		ActionListener insertar = new InsertaNumero();
		ActionListener operacion = new AccionOperacion();
		boolean bucle=true;
		
		for (int i= 0; i < botones.length; i++) {
			for (int j = 0; j < botonesNoNumericosString.length; j++) {
				if (botones[i] == botonesNoNumericosString[j]) {
					creaBoton(botones[i],operacion);
					bucle=false;
				}
			}
			if(bucle) creaBoton(botones[i],insertar);
			bucle=true;

		}
	}
	
	private void creaBoton(String rotulo, ActionListener oyente) {
		JButton boton= new JButton(rotulo);
		boton.addActionListener(oyente);
		laminaBotonera.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Nos devuelve el String asociado con la accion(fuente?).
			String entrada = e.getActionCommand();
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			//A lo que hay ya en la pantalla le agrega el string del boton
			pantalla.setText(pantalla.getText()+entrada);
		}
		
	}
	
	private class AccionOperacion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			operacion=e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
//			if(operacion != "=") {
//				ultimaoperacion=operacion;	
//			}
			
			principio=true;
		}
		
		public void calcular(double x) {
		switch (operacion) {
		case "+":
			resultado +=x;
			System.out.println("Suma: "+resultado);
			break;
		case "-":
			resultado -=x;
			System.out.println("Restar: "+resultado);
			break;
		case "/":
			resultado /=x;
			System.out.println("Dividir: "+resultado);
			break;
		case "*":
			resultado *=x;
			System.out.println("Multiplicar: "+resultado);
			break;
		case ".":
			System.out.println("Punto: ");
			break;
		case "C":
			resultado=0;
			pantalla.setText(""+resultado);
			System.out.println("Borrar: ");
			break;
		case "=":
			resultado
			pantalla.setText(""+resultado);
			System.out.println("Resultado: "+resultado);
			break;
		default:
			break;
		} 	
		}
		
	}
	
	private JPanel laminaBotonera;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
	private String operacion;
	
	
}

