package es.ifp.cajero.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ifp.cajero.modelo.beans.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer>{

}
