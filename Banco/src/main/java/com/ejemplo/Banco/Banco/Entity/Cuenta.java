package com.ejemplo.Banco.Banco.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCuenta;

    @Column(name="Titular", nullable = false)
    private String titular;

    @Column(name="IBAN", nullable = false, unique = true)
    private String iban;

    @Column(name = "Saldo")
    private int saldo;

    @Column(name = "Saldo Disponible")
    private int saldoDisponible;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimiento> movimientos;

    public Cuenta(int idCuenta, String titular, String iban, int saldo, int saldoDisponible,
            User user) {
        this.idCuenta = idCuenta;
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldo;
        this.saldoDisponible = saldoDisponible;
        this.usuario = user;
    }

    public Cuenta() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public User getUser() {
        return usuario;
    }

    public void setUser(User user) {
        this.usuario = user;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
