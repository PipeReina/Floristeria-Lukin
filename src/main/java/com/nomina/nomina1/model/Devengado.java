package com.nomina.nomina1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="devengados")
public class Devengado {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDDev;
    @NotNull
    private Double totalDev;
    @NotEmpty
    @Size(min=10,max=10)
    @Column(length = 4,nullable=false)
    private String fechaDev;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    
    public Devengado(){

    }

    public Devengado(Integer idDDev, @NotNull Double totalDev, @NotEmpty @Size(min = 10, max = 10) String fechaDev,
            Empleado fKempleado) {
        this.idDDev = idDDev;
        this.totalDev = totalDev;
        this.fechaDev = fechaDev;
        FKempleado = fKempleado;
    }

    public Integer getIdDDev() {
        return idDDev;
    }

    public void setIdDDev(Integer idDDev) {
        this.idDDev = idDDev;
    }

    public Double getTotalDev() {
        return totalDev;
    }

    public void setTotalDev(Double totalDev) {
        this.totalDev = totalDev;
    }

    public String getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(String fechaDev) {
        this.fechaDev = fechaDev;
    }

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

    
    
}