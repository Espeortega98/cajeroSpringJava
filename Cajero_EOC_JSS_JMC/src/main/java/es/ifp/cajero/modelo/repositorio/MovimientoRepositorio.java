package es.ifp.cajero.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.ifp.cajero.modelo.beans.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Integer>{
	
	@Query("select m from Movimiento m where m.cuenta.idCuenta=?1")
	public List<Movimiento> buscarPorCuenta(int idCuenta); //Te devuelve una lista de movimientos a raiz de un id

}
