package es.ifp.cajero.modelo.dao;

import java.util.List;

import es.ifp.cajero.modelo.beans.Cuenta;

public interface IntCuentaDao {
	
	public List<Cuenta> findAll();
	public Cuenta findOne(int idCuenta);
	public int modificarUna(Cuenta cuenta);
}
