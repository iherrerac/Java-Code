package calculadora;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Aplicación Calculadora tipo Windows
 */

public class Calculadora {

	public static void main(String[] args) {
		Marco M1 = new Marco();
		M1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco extends JFrame{
	JLabel pantalla; //Inicializamos botones
	int numeroDeBotones = 17;// Numeros de botones
	JButton[] botones = new JButton[numeroDeBotones]; //Declaramos Botones
	//Texto de los botones
	String[] textoBotones =  {"=","7","8","9","/","4","5","6","*","1","2","3","-","C","0",".","+"};
	//Posicion
	int[] setX = {210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210};
	int[] setY = {350, 155, 155, 155, 155, 220, 220, 220, 220, 285, 285, 285, 285, 350, 350, 350, 350};
	//Indicamos los botones que son numeros
	int[] BotonesSonNumeros = {1,2,3,5,6,7,9,10,11,14};
	double operador1 = 0;
	double operador2 = 0;
	double resultado = 0;
	boolean puntoDecimal = false; //Para saber si hemos usado el punto decimal ya
	boolean nuevoNumero = true; // Para ver si hemos terminado de escribir el numero
	String operacion = ""; // Saber que operacion es / + * -
	
	
	public Marco() {
		setVisible(true);
		setTitle("Calculadora");
		setBounds(150,100,300,480);
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
 		initPantalla();
		initBotones();
		eventoNumeros();
		Panel P1 = new Panel();
		add(P1);
	}
	
	private void initPantalla(){
		pantalla = new JLabel("0"); //Inicio JLabel
        pantalla.setBounds(15, 15, 245, 60); //Posición y dimensiones
        pantalla.setOpaque(true);
        pantalla.setBackground(Color.BLACK);//Color fondo
        pantalla.setForeground(Color.GREEN);//Color fuente
        pantalla.setFont(new Font("MONOSPACED", Font.PLAIN, 24));
        pantalla.setBorder(new LineBorder(Color.DARK_GRAY)); //Borde
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT); //Alineamiento horizontal derecha
        add(pantalla);
	}
	
	private void initBotones(){
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new JButton(textoBotones[i]); //Inicializo JButton
			botones[i].setBounds(setX[i],setY[i],50,50); //Posición y dimensiones
            botones[i].setFont(new Font("MONOSPACED",Font.PLAIN,24)); //Fuente
            botones[i].setOpaque(true); //Color de fondo
            botones[i].setFocusPainted(false); //Para que no salga una recuadro azul cuando tenga el foco
            botones[i].setBackground(Color.DARK_GRAY); //Color de fondo
            botones[i].setForeground(Color.WHITE); //Color de fuente
 //           botones[i].setBorder(new LineBorder(Color.DARK_GRAY)); //Borde
			add(botones[i]);
		}
	}
	//Añadir a cada boton numerico su ActionListener y su metodo actionEvent
	private void eventoNumeros() {
		
		for (int i = 0; i < BotonesSonNumeros.length; i++) {
			int numboton = BotonesSonNumeros[i];
			//declaramos el listener sobre la marcha y sobrescribimos
			botones[BotonesSonNumeros[i]].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					pantalla.setText(textoBotones[numboton]);
					System.out.println(textoBotones[numboton]);
				}
			});

		}
	}
}

class Panel extends JPanel{
	
	public Panel() {
		setBackground(Color.DARK_GRAY);
	}
	
	
}



