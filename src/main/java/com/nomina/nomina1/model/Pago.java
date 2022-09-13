package com.nomina.nomina1.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="pago")
public class Pago {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;
    @NonNull
    @Column(length = 10)
    @Size (min=2, max=10)
    private String fechaPago;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FKdevengado_id", referencedColumnName = "idDev")
    private Devengado FKdevengado;
    
    public Pago() {
    }

    public Pago(Integer idPago, @Size(min = 2, max = 10) String fechaPago, Devengado fKdevengado) {
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

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Devengado getFKdevengado() {
        return FKdevengado;
    }

    public void setFKdevengado(Devengado fKdevengado) {
        FKdevengado = fKdevengado;
    }

    

    

    

   
    
}