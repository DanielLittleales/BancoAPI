package com.ejemplo.Banco.Banco.DAO;

import com.ejemplo.Banco.Banco.Entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iMovimientoRepository extends JpaRepository<Movimiento, Integer> {

}
