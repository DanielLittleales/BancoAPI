package com.ejemplo.Banco.Banco.Controller;

import com.ejemplo.Banco.Banco.DTO.CuentaDTO;
import com.ejemplo.Banco.Banco.Entity.Cuenta;
import com.ejemplo.Banco.Banco.Exceptions.CuentaExceptions;
import com.ejemplo.Banco.Banco.Exceptions.CuentaNotFoundException;
import com.ejemplo.Banco.Banco.Service.CuentaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins="http://localhost:8080")
public class CuentaController {

    @Autowired
    private CuentaService cuentaservice;

    @PostMapping(path = "create")
    public ResponseEntity<?> create(@RequestBody CuentaDTO cuenta) {
        if(!cuentaservice.checkSaldo(cuenta)) {
            throw new CuentaNotFoundException("No puede haber más saldo disponible que saldo total");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaservice.save(cuenta));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") int cuentaId) {
        Optional<Cuenta> opCuenta = cuentaservice.findById(cuentaId);
        if (!opCuenta.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opCuenta);
    }

    @GetMapping
    public List<Cuenta> readAll() {
        return StreamSupport
                .stream(cuentaservice.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @ExceptionHandler
    public ResponseEntity<CuentaExceptions> handleException(CuentaNotFoundException excp) {

        //Create a CeuntaException

        CuentaExceptions error = new CuentaExceptions();
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(excp.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //Return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

}
