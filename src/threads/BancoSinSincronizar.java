package threads;

/*
 * Cuentas 100
 * Saldo inicial en cuentas 2000 euros
 * Saldo total todas las cuentas 2000x100 = 200.000
 * Tranferencias constantes de unas cuentas a otras, el saldo total no se modificara
 * hasta que llegue en un momento en que el saldo total
 */
public class BancoSinSincronizar {

	public static void main(String[] args) {

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
		//Controlar que la tranferencia no sea mayor que el saldo en cuenta
		if (cantidad > cuentas[cuentaOrigen]) return;
		//Imprimimos el hilo que hace la tranferencia como control
		System.out.println(Thread.currentThread());
		
	}
	
	private final double[] cuentas;
}
