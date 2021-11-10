package poo;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;//Libreria para el temporizador
import java.awt.event.*;//Libreria para la interface ActionListener 
import java.awt.Toolkit;//Caracteristicas windows
import java.util.*;

public class Temporizador2 {

	public static void main(String[] args) {
		// Mensaje en consola con la hora cada 5 segundos
		//Igual que en Temporizador.java pero con una clase interna (DameLaHora2)
		Reloj miReloj = new Reloj(3000, true);
		miReloj.enMarcha();
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		System.exit(0);
	}
}	


class Reloj{
	public Reloj (int intervalo,boolean sonido) {//CONSTRUCTOR
		this.intervalo = intervalo;
		this.sonido = sonido;
	}

		
		public void enMarcha() {
			//Declaramos el Listener esta vez con polimorfismo 
			ActionListener oyente = new DameLaHora2();
			Timer miTemporizador= new Timer(this.intervalo,oyente);
			miTemporizador.start();
		}
		private int intervalo;
		private boolean sonido;
		//Clase interna
		private class DameLaHora2 implements ActionListener{
			public void actionPerformed(ActionEvent evento) {
				Date hora = new Date();
				System.out.println("la hora cada 5 segundos: "+ hora);
				if(sonido) Toolkit.getDefaultToolkit().beep(); //sonido Windows
			}
		}
}
