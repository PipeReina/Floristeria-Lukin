package com.nomina.nomina1.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="pago")
public class Pago {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;
    @NotEmpty
    @Column(length = 10)
    @Size (min=2, max=10)
    private Date fechaPago;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pago FKdevengado;
    
    public Pago() {
    }

    public Pago(Integer idPago, Date fechaPago, Pago fKdevengado) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        FKdevengado = fKdevengado;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Pago getFKdevengado() {
        return FKdevengado;
    }

    public void setFKdevengado(Pago fKdevengado) {
        FKdevengado = fKdevengado;
    }

    
}