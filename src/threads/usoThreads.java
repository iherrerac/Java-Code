package threads;

import java.awt.geom.*;
import java.util.*;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

/*
 * Video 168 Threads: Aplicacion Monotarea que crea una pelota que rebota por los 
 * borders de una lamina. vamos convertirlo en multitarea, que use varios hilos de ejecucion
 * Video !69 Inturrumpir la ejecucion de un hilo
 */

public class usoThreads {

	public static void main(String[] args) {
		
		JFrame marco = new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

//Threads
class PelotaHilos implements Runnable{
	
	public PelotaHilos (Pelota unaPelota, Component unComponente) {//pelota y lamina
		pelota=unaPelota;
		componente=unComponente;
	}
	
	@Override
	public void run() {
		
		for(int i=1;i<3000;i++) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());//repinta la lamina
			
			try {
				Thread.sleep(4);//bloquea el hilo
			} catch (InterruptedException e) {
				//e.printStackTrace();//imprime el estado de la pila
				System.out.println("Hilo bloqueado imposible interrupcion");
				//System.exit(0);
			}
			
			
		}
	}
	
	private Pelota pelota;
	private Component componente;
}
//Movimiento de la pelota
class Pelota {
	//Mueve la pelota invirtiendo posicion si bota con los limites
	public void mueve_pelota(Rectangle2D limites) {//recibe las dimensiones de nuestra lamina
		x+=dx;
		y+=dy;
		
		if (x<limites.getMinX()) {
			x=limites.getMinX();
			dx=-dx;//invertimos la x
		}
		
		if(x + TAMX>=limites.getMaxX()) {
			x=limites.getMaxX() -TAMX;
			dx =-dx;
		}
		
		if (y<limites.getMinY()) {
			y=limites.getMinY();
			dy=-dy; // invertimos la Y
		}
		
		if(y + TAMY>=limites.getMaxY()) {
			y=limites.getMaxY() -TAMY;
			dy =-dy;
		}
	}
	
	//Forma de la pelota en su posicion inicial
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}

//Lamina que dibuja las pelotas
class LaminaPelota extends JPanel{
	//Añadimos pelota a la lamina
	public void add(Pelota b) {
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b:pelotas) {
			g2.fill(b.getShape());
		}
	}
	
	private ArrayList<Pelota> pelotas= new ArrayList<Pelota>(); 
}

//Marco
class MarcoRebote extends JFrame{
	public MarcoRebote() {
		setBounds(600,300,400,350);
		setTitle("Rebotes");
		lamina=new LaminaPelota();
		add(lamina,BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();
		//boton comenzar
		ponerBoton(laminaBotones,"Dale!",new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego();
			}
		});
		//Boton salir
		ponerBoton(laminaBotones,"Salir",new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				System.exit(0);
			}
		});

		add(laminaBotones,BorderLayout.SOUTH);
	}
	
	//ponemos botones
	public void ponerBoton(Container c,String titulo,ActionListener oyente) {
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	//Añade pelota y la bota 3000 veces
	public void comienza_el_juego() {
		Pelota pelota=new Pelota();
		lamina.add(pelota);
		//Multitarea
		Runnable r= new PelotaHilos(pelota,lamina);
		t= new Thread(r);
		t.start();
		
		//MonoTarea
//		for(int i=1;i<3000;i++) {
//			pelota.mueve_pelota(lamina.getBounds());
//			lamina.paint(lamina.getGraphics());//repinta la lamina
//			try {
//				Thread.sleep(4);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			
//		}
		
	}

	private LaminaPelota lamina;
	private Thread t;
}
