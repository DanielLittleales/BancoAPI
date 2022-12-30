package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.Entity.Movimiento;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iMovimientoService {

    public Iterable<Movimiento> findAll();

    public Page<Movimiento> findAll(Pageable pageable);

    public Optional<Movimiento> findById(int id);

    public Movimiento save(Movimiento movimiento);

    public void deleteById(int id);
}
