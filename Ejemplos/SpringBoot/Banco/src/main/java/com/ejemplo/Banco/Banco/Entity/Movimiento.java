package com.ejemplo.Banco.Banco.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMovimientos;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name ="Titular")
    private String titular;

    @Column(name = "Destinatario")
    private String destinatario;

    @Column(name = "Importe")
    private int importe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    public Movimiento(int idMovimientos, Date fecha, String titular, String destinatario, int importe,
            Cuenta cuenta) {
        this.idMovimientos = idMovimientos;
        this.fecha = fecha;
        this.titular = titular;
        this.destinatario = destinatario;
        this.importe = importe;
        this.cuenta = cuenta;
    }

    public Movimiento() {
    }

    public int getIdMovimientos() {
        return idMovimientos;
    }

    public void setIdMovimientos(int idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
