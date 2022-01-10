package threads;

/*
 * Video 171. Sincronizacion de hilos
 * Video 172. Sincronizacion de hilos II: Vamos a pasarle como parametro el hilo que queremos
 * hacerle join.
 */

public class SincronizandoHilos {

	public static void main(String[] args) {
		HilosVarios hilo1= new HilosVarios();
		HilosVarios hilo2= new HilosVarios();
		HilosVarios2 hilo3= new HilosVarios2(hilo1);
		hilo3.start();
		hilo1.start();
		//Hasta que no muera el primer hilo no comienza el segundo
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Hasta que no muera el segundo hilo no comienza el sysout
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminadas las tareas");
	}

}

//En vez de implementar la interface Runnable, puede heredar de Threads por ejemplo
class HilosVarios extends Thread{
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo: "+getName());
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class HilosVarios2 extends Thread{
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	public void run() {
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo: "+getName());
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private Thread hilo;

}