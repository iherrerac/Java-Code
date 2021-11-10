package poo;


import javax.swing.JOptionPane;
import javax.swing.Timer;//Lib temporizador
import java.awt.event.*;//Lib interface ActionListener 
import java.awt.Toolkit;//Caracteristicas windows
import java.util.*;

public class Temporizador3 {

	public static void main(String[] args) {
		// Mensaje en consola con la hora cada 3 segundos
		//Ahora con una clase interna LOCAL (DameLaHora2)
		Reloj miReloj = new Reloj();
		miReloj.enMarcha(7000,true);
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		System.exit(0);
	}
}	


class Reloj{
	//prescindimos del constructor, por lo que lo da por defecto
//	public Reloj (int intervalo,boolean sonido) {//CONSTRUCTOR
//		this.intervalo = intervalo;
//		this.sonido = sonido;
//	}

		
		public void enMarcha(int intervalo,boolean sonido) {
			//Clase interna LOCAL
			 class DameLaHora2 implements ActionListener{
				public void actionPerformed(ActionEvent evento) {
					Date hora = new Date();
					System.out.println("Hora: "+ hora);
					if(sonido) Toolkit.getDefaultToolkit().beep(); //sonido Windows
				}
			}
			//Declaramos el Listener esta vez con polimorfismo 
			ActionListener oyente = new DameLaHora2();
			Timer miTemporizador= new Timer(this.intervalo,oyente);
			miTemporizador.start();
		}
		private int intervalo;

}
