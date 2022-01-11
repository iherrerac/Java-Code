package threads;

import java.util.concurrent.locks.*;
//import java.util.concurrent.locks.ReentrantLock;

/* 
 * Video 173,174,175,176,177
 * Aplicacion que construye un banco con 100 cuentas
 * Saldo inicial en cuentas 2000 euros
 * Saldo total todas las cuentas 2000x100 = 200.000
 * Tranferencias constantes de unas cuentas a otras realizadas por un Thread, 
 * el saldo total no se modificara .... o eso deberia pasar
 * ¿Por que se modifica el saldo total, cuando deberia ser siempre fija ( 200000 )
 * por que hay varias transferencias concurrentes.
 * Video 178 Sincronizad agregamos la palabra sincronized en el metodo, wait()  para la condicion y 
 * notifyAll() para despertar hilos. cierre Implicito SOLO UNA CONDICION
 */

public class BancoSincronizadoConSynchronized {

	public static void main(String[] args) {
		Banco1 b1= new Banco1();
		for ( int i=0; i<100;i++) {
			EjecucionTransferencias1 r = new EjecucionTransferencias1(b1, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Banco1{
	public Banco1() {
		cuentas = new double[100];
		for (int i=0; i< cuentas.length; i++) {
			cuentas[i]= 2000;
		}

	}
	
	public synchronized void  transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) throws InterruptedException {

			//Controlar que la tranferencia no sea mayor que el saldo en cuenta
			while (cantidad > cuentas[cuentaOrigen]) {
				wait();//Si la condicion se cumple, hilo a la espera
			} 
			
			//Imprimimos el hilo que hace la tranferencia como control
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen]-=cantidad;//Dinero que sale de la cuenta
			//Imprime con un formato determinado(2decimales)
			System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
			cuentas[cuentaDestino]+=cantidad; //Suma a la cuenta destino
			System.out.printf(" Saldo total: %10.2f%n",getSaldoTotal());
			notifyAll(); //Revisar la condicion
	}	
	//metodo devuelve el saldo total
	public double getSaldoTotal() {
		double suma_cuentas = 0;
		for (double a:cuentas) {
			suma_cuentas +=a;
		}
		return suma_cuentas;
	}
	
	private final double[] cuentas;
}

//Clase para los Threads de las transferencias
class EjecucionTransferencias1 implements Runnable{
	//variable de tipo banco, int cuentas origen, maximo de la transferencia
	public EjecucionTransferencias1 (Banco1 b,int de,double max) {
		banco = b;
		delaCuenta=de;
		cantidadMax=max;
	}
	
	//en el run la cuenta origen la tenemos pero la cuenta destino y la cantidad a tranferir 
	//es random
	@Override
	public void run() {
		try {
		while (true) {
			int paraLaCuenta=(int)(100*Math.random());
			double cantidad= cantidadMax*Math.random();
			banco.transferencia(delaCuenta, paraLaCuenta, cantidad);
			//Ralentizamos las operaciones aleatoriamente
			Thread.sleep((int)Math.random()*10);
			} 
		} catch (InterruptedException e) {}
		
	}
	
	private Banco1 banco;
	private int delaCuenta;//cuenta Origen
	private double cantidadMax;
}
