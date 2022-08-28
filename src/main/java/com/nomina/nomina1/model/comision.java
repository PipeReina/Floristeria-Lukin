package com.nomina.nomina1.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name="comisiones")
public class comision {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdComision;

    @Column (length = 50)
    private Integer CostoVenta;

    @Column (length = 50, nullable=true)
    private String FechaCom;
    
    @Column (length = 50, nullable=true)
    private Boolean EstadoCom;

    @ManyToOne (fetch = FetchType.LAZY)
    private Empleado IdEmpleadoFK;


    //constructores
    public comision(){

    }


    public comision(Integer idComision, Integer costoVenta, String fechaCom, Boolean estadoCom, Empleado idEmpleadoFK) {
        IdComision = idComision;
        CostoVenta = costoVenta;
        FechaCom = fechaCom;
        EstadoCom = estadoCom;
       IdEmpleadoFK = idEmpleadoFK;
    }


    public Integer getIdComision() {
        return IdComision;
    }


    public void setIdComision(Integer idComision) {
        IdComision = idComision;
    }


    public Integer getCostoVenta() {
        return CostoVenta;
    }


    public void setCostoVenta(Integer costoVenta) {
        CostoVenta = costoVenta;
    }


    public String getFechaCom() {
        return FechaCom;
    }


    public void setFechaCom(String fechaCom) {
        FechaCom = fechaCom;
    }


    public Boolean getEstadoCom() {
        return EstadoCom;
    }

    public void setEstadoCom(Boolean estadoCom) {
        EstadoCom = estadoCom;
    }


    public Empleado getIdEmpleadoFK() {
        return IdEmpleadoFK;
    }


    public void setIdEmpleadoFK(Empleado idEmpleadoFK) {
        IdEmpleadoFK = idEmpleadoFK;
    }

     }

    