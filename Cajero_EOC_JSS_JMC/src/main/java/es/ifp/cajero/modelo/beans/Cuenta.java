package es.ifp.cajero.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cuenta")
	private int idCuenta;

	private double saldo;

	@Column(name="tipo_cuenta")
	private String tipoCuenta;

	public Cuenta() {
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public void extraerSaldo(double cantidad) {
		this.saldo-=cantidad; //Resta la cantidad extraida a la cantidad inicial
	}
	
	public void ingresarSaldo(double cantidad) {
		this.saldo+=cantidad;//Suma la cantidad ingresada a la cantidad inicial
	}
	

}