package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.DAO.iMovimientoRepository;
import com.ejemplo.Banco.Banco.Entity.Movimiento;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService implements iMovimientoService {

    @Autowired
    private iMovimientoRepository repository;

    @Override
    public Iterable<Movimiento> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Movimiento> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Movimiento> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Movimiento save(Movimiento movimiento) {
        return repository.save(movimiento);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
