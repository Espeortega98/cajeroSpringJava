package es.ifp.cajero.modelo.dao;

import java.util.List;

import es.ifp.cajero.modelo.beans.Movimiento;

public interface IntMovimientoDao {
	
	public List<Movimiento> findAll();
	public Movimiento findOne(int idMovimiento);
	public List<Movimiento> findByCuenta(int idCuenta);
	public int insertOne(Movimiento movimiento);
	
}
