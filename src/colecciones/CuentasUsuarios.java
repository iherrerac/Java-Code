package colecciones;

import java.util.*;

/* 
 * Video 180 Uso de colecciones
 * Aplicacion Banco que usa una coleccion para almacenar los clientes
 * Los getter y setter los generamos directamente con source-> Generate GyS
 * Coleccion que no repita clientes, muchas operaciones de agregar y borrar, muchas solo lectura
 * En principio no necesitamos ordenacion para este ejemplo.
 * Video 181: Equals() y HasCode()
 * Video 182: Rescribiendo Equals() y HasCode()
 */

public class CuentasUsuarios {

	public static void main(String[] args) {
		Cliente cl1 = new Cliente("Antonio Banderas","00001",200000);
		Cliente cl2 = new Cliente("Rafael Nadal","00002",250000);
		Cliente cl3 = new Cliente("Penelope Cruz","00003",300000);
		Cliente cl4 = new Cliente("Julio Iglesias","00004",500000);
		Cliente cl5 = new Cliente("Antonio Banderas","00001",200000);
		
		//Setes Interfaces, tenemos que implementar la clase que la implemente 
		//en este caso nos conviene HashSet (Rápida, no duplicados, no ordenación, y sin acceso aleatorio)
		Set <Cliente> clientesBanco = new HashSet<Cliente>();
		//El metodo add gestiona los duplicados
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
		
		for (Cliente cliente: clientesBanco) {
			System.out.println(cliente.getNombre()+" "
			+cliente.getN_cuenta()+" "+cliente.getSaldo());
		}
	}

}
