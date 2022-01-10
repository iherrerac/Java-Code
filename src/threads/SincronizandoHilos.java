package threads;

/*
 * * Video 171. Sincronizacion de hilos
 */

public class SincronizandoHilos {

	public static void main(String[] args) {
		HilosVarios hilo1= new HilosVarios();
		HilosVarios hilo2= new HilosVarios();
		hilo1.start();
		//Hasta que no muera el primer hilo no comienza el segundo
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo2.start();
		System.out.println("Terminadas las tareas");// Realmente no estan terminadas, estan lanzadas
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