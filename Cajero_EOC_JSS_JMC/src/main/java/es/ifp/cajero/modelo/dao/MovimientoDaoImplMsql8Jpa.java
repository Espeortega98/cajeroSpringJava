package es.ifp.cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ifp.cajero.modelo.beans.Movimiento;
import es.ifp.cajero.modelo.repositorio.MovimientoRepositorio;

@Service
public class MovimientoDaoImplMsql8Jpa implements IntMovimientoDao{
	@Autowired
	private MovimientoRepositorio mrepo;
	
	@Override
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return (List<Movimiento>) mrepo.findAll();
	}

	@Override
	public Movimiento findOne(int idMovimiento) {
		// TODO Auto-generated method stub
		return mrepo.findById(idMovimiento).orElse(null);
	}

	@Override
	public List<Movimiento> findByCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return mrepo.buscarPorCuenta(idCuenta);
	}

	@Override
	public int insertOne(Movimiento movimiento) {
		int filas=0;
		
		try {
			mrepo.save(movimiento);
			filas=1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}

}
