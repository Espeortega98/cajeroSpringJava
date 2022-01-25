package es.ifp.cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.ifp.cajero.modelo.beans.Cuenta;
import es.ifp.cajero.modelo.repositorio.CuentaRepositorio;
@Service

public class CuentaDaoImpMsql8Jpa implements IntCuentaDao{

	@Autowired
	private CuentaRepositorio crepo;
	@Override
	public Cuenta findOne(int idProducto) {
		
		return crepo.findById(idProducto).orElse(null);
	}

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) crepo.findAll();
	}

	@Override
	public int modificarUna(Cuenta cuenta) {
		int filas=0;
		try {
			crepo.save(cuenta);
			filas=1;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return filas;
	}

}
