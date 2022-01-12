package colecciones;

import java.util.Objects;

/* 
 * Video 180 Uso de colecciones
 * Aplicacion Banco que usa una coleccion para almacenar los clientes
 * Los getter y setter los generamos directamente con source-> Generate GyS
 * Coleccion que no repita clientes, muchas operaciones de agregar y borrar, muchas solo lectura
 * En principio no necesitamos ordenacion para este ejemplo.
 */

public class Cliente {
	public Cliente(String nombre, String n_cuenta, double saldo) {
		this.nombre= nombre;
		this.n_cuenta=n_cuenta;
		this.saldo=saldo;
	}
	
	//Getter y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getN_cuenta() {
		return n_cuenta;
	}
	public void setN_cuenta(String n_cuenta) {
		this.n_cuenta = n_cuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(n_cuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(n_cuenta, other.n_cuenta);
	}



	private String nombre;
	private String n_cuenta;
	private double saldo;
}
