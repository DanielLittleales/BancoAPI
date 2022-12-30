package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.DTO.CuentaDTO;
import com.ejemplo.Banco.Banco.Entity.Cuenta;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iCuentaService {

    public Iterable<Cuenta> findAll();

    public Page<Cuenta> findAll(Pageable pageable);

    public Optional<Cuenta> findById(int id);

    public Cuenta save(CuentaDTO cuentaDto);

    public void deleteById(int id);
}
