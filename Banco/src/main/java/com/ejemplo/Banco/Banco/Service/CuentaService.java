package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.DAO.iCuentaRepository;
import com.ejemplo.Banco.Banco.DAO.iUserRepository;
import com.ejemplo.Banco.Banco.DTO.CuentaDTO;
import com.ejemplo.Banco.Banco.Entity.Cuenta;
import com.ejemplo.Banco.Banco.Entity.User;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CuentaService implements iCuentaService {

    @Autowired
    private iCuentaRepository repository;
    @Autowired
    private UserService userService;

    @Override
    public Iterable<Cuenta> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Cuenta> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Cuenta> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Cuenta save(CuentaDTO cuentaDto) {
        Optional<User> oUser = userService.findById(cuentaDto.getUserId());
        if (!oUser.isPresent()) {
            return null;
        }
        User newUser = oUser.get();
        Cuenta cuenta = new Cuenta(cuentaDto.getIdCuenta(), cuentaDto.getTitular(), cuentaDto.getIban(), cuentaDto.getSaldo(), cuentaDto.getSaldoDisponible(), newUser);
        return repository.save(cuenta);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Boolean checkSaldo(CuentaDTO cuenta) {
        if(cuenta.getSaldo() < cuenta.getSaldoDisponible() || cuenta.getSaldoDisponible() < 0) {
            return false;
        }
        return true;
    }
}
