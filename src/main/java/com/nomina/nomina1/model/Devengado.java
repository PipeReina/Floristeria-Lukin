package com.nomina.nomina1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="devengado")
public class Devengado {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDev;
    @NotNull
    private Double totalDev;
    @Column(length = 10)
    private String fechaDev=getFechaActual();
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    @OneToOne(mappedBy = "FKdevengado")
    private Pago FKpago;
    public Devengado(){

    }

    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
    

    public Devengado(Integer idDev, @NotNull Double totalDev, String fechaDev, Empleado fKempleado) {
        this.idDev = idDev;
        this.totalDev = totalDev;
        this.fechaDev = fechaDev;
        FKempleado = fKempleado;
    }



    public Integer getIdDev() {
        return idDev;
    }

    public void setIdDev(Integer idDev) {
        this.idDev = idDev;
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