package com.nomina.nomina1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name="cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCargo")
    private Integer idCargo;
    @NotEmpty    
    @Column(name="nombreCargo", length=20)
    private String nombreCargo;
    @NotEmpty    
    @Column(name="DescripcionCargo", length=100)
    private String DescripcionCargo;
    @Column(name="estadoCargo") 
    private Boolean estadoCargo;
    @OneToMany(mappedBy = "FKcargo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Empleado> FKempleado;

    public Cargo(){
        FKempleado=new ArrayList<Empleado>();
    }

    public Cargo(Integer idCargo, @NotEmpty String nombreCargo, @NotEmpty String descripcionCargo, Boolean estadoCargo,
            List<Empleado> fKempleado) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        DescripcionCargo = descripcionCargo;
        this.estadoCargo = estadoCargo;
        FKempleado = fKempleado;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescripcionCargo() {
        return DescripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        DescripcionCargo = descripcionCargo;
    }

    public Boolean getEstadoCargo() {
        return estadoCargo;
    }

    public void setEstadoCargo(Boolean estadoCargo) {
        this.estadoCargo = estadoCargo;
    }

    public List<Empleado> getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(List<Empleado> fKempleado) {
        FKempleado = fKempleado;
    }



    
}
