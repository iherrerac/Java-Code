package threads;

import java.util.concurrent.locks.*;
//import java.util.concurrent.locks.ReentrantLock;

/* 
 * Video 173,174,175
 * Aplicacion que construye un banco con 100 cuentas
 * Saldo inicial en cuentas 2000 euros
 * Saldo total todas las cuentas 2000x100 = 200.000
 * Tranferencias constantes de unas cuentas a otras realizadas por un Thread, 
 * el saldo total no se modificara .... o eso deberia pasar
 * ¿Por que se modifica el saldo total, cuando deberia ser siempre fija ( 200000 )
 * por que hay varias transferencias concurrentes.
 * En el video 175 explican para la sincronizacion como usar la clase ReentrantLock que hereda 
 * de la Interface Lock, mismo uso que join() pero para casos mas complejos
 */

public class BancoSinSincronizar {

	public static void main(String[] args) {
		Banco b= new Banco();
		for ( int i=0; i<100;i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}

}

class Banco{
	public Banco() {
		cuentas = new double[100];
		for (int i=0; i< cuentas.length; i++) {
			cuentas[i]= 2000;
		}
	}
	
	public void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) {
		cierreBanco.lock();//Bloqueamos hilo y rodeamos de try
		try {
			//Controlar que la tranferencia no sea mayor que el saldo en cuenta
			if (cantidad > cuentas[cuentaOrigen]) return;
			//Imprimimos el hilo que hace la tranferencia como control
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen]-=cantidad;//Dinero que sale de la cuenta
			//Imprime con un formato determinado(2decimales)
			System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
			cuentas[cuentaDestino]+=cantidad; //Suma a la cuenta destino
			System.out.printf(" Saldo total: %10.2f%n",getSaldoTotal());
		}finally {//tanto si ocurre una excepcion o no haga esto ...
			cierreBanco.unlock();
		}
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
	//Instanciamos cierreBanco para sincronizacion de hilos y poder llamar a metodos lock y unlock
	private Lock cierreBanco= new ReentrantLock();
}

//Clase para los Threads de las transferencias
class EjecucionTransferencias implements Runnable{
	//variable de tipo banco, int cuentas origen, maximo de la transferencia
	public EjecucionTransferencias (Banco b,int de,double max) {
		banco = b;
		delaCuenta=de;
		cantidadMax=max;
	}
	
	//en el run la cuenta origen la tenemos pero la cuenta destino y la cantidad a tranferir 
	//es random
	@Override
	public void run() {
		while (!Thread.currentThread().interrupted()) {
			int paraLaCuenta=(int)(100*Math.random());
			double cantidad= cantidadMax*Math.random();
			banco.transferencia(delaCuenta, paraLaCuenta, cantidad);
			//Ralentizamos las operaciones aleatoriamente
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Banco banco;
	private int delaCuenta;//cuenta Origen
	private double cantidadMax;
}
