package com.nomina.nomina1.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@Entity
@Table (name = "hse")
public class he {

    //atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer IdHorasExtra;

    @Column (length = 50,nullable=true)
    private String FechaHE;

    @Column (length = 50, nullable=true)
    private Boolean EstadoHE;

    @ManyToOne (fetch = FetchType.LAZY)
    private Empleado IdEmpleadoFK;


    //constructores

    public he(){
        
    }


    public he(Integer idHorasExtra, String fechaHE, Boolean estadoHE, Empleado idEmpleadoFK) {
        IdHorasExtra = idHorasExtra;
        FechaHE = fechaHE;
        EstadoHE = estadoHE;
        IdEmpleadoFK = idEmpleadoFK;
    }


    public Integer getIdHorasExtra() {
        return IdHorasExtra;
    }


    public void setIdHorasExtra(Integer idHorasExtra) {
        IdHorasExtra = idHorasExtra;
    }


    public String getFechaHE() {
        return FechaHE;
    }


    public void setFechaHE(String fechaHE) {
        FechaHE = fechaHE;
    }


    public Boolean getEstadoHE() {
        return EstadoHE;
    }


    public void setEstadoHE(Boolean estadoHE) {
        EstadoHE = estadoHE;
    }


    public Empleado getIdEmpleadoFK() {
        return IdEmpleadoFK;
    }


    public void setIdEmpleadoFK(Empleado idEmpleadoFK) {
        IdEmpleadoFK = idEmpleadoFK;
    }

    
    
    
}
