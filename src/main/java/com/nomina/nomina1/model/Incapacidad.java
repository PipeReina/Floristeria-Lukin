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

@Entity
@Table(name="incapacidad")
public class Incapacidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idIncapacidad")
    private Integer idIncapacidad;
    @Column(name="fechaInicio", length=20)
    private Date fechaInicio;
    @Column(name="fechaFinal", length=20)
    private Date fechaFinal;
    @NotEmpty    
    @Column(name="soporteIncapacidad", length=200)
    private String soporteIncapacidad;
    @Column(name="estadoIncapacidad") 
    private Boolean estadoIncapacidad;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;

    public Incapacidad(){

    }

    public Incapacidad(Integer idIncapacidad, @NotEmpty Date fechaInicio, @NotEmpty Date fechaFinal,
            @NotEmpty String soporteIncapacidad, Boolean estadoIncapacidad, Empleado fKempleado) {
        this.idIncapacidad = idIncapacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.soporteIncapacidad = soporteIncapacidad;
        this.estadoIncapacidad = estadoIncapacidad;
        FKempleado = fKempleado;
    }

    public Integer getIdIncapacidad() {
        return idIncapacidad;
    }

    public void setIdIncapacidad(Integer idIncapacidad) {
        this.idIncapacidad = idIncapacidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getSoporteIncapacidad() {
        return soporteIncapacidad;
    }

    public void setSoporteIncapacidad(String soporteIncapacidad) {
        this.soporteIncapacidad = soporteIncapacidad;
    }

    public Boolean getEstadoIncapacidad() {
        return estadoIncapacidad;
    }

    public void setEstadoIncapacidad(Boolean estadoIncapacidad) {
        this.estadoIncapacidad = estadoIncapacidad;
    }

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

    
}