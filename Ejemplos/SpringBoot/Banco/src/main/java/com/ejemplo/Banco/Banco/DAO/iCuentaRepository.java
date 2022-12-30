package com.ejemplo.Banco.Banco.DAO;

import com.ejemplo.Banco.Banco.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCuentaRepository extends JpaRepository<Cuenta, Integer> {

}
