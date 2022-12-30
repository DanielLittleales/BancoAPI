package com.ejemplo.Banco.Banco.DTO;

import javax.annotation.sql.DataSourceDefinition;


public class CuentaDTO {

    private int idCuenta;
    private String titular;
    private String iban;
    private int saldo;
    private int saldoDisponible;
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
