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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="convenio")
public class Convenio {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConvenio;
    @NotEmpty
    @Range(min=1,max=10)
    @Column(length = 4,nullable=false)
    private Integer horaConvenio;
    @Range(min=1,max=10)
    @Column(length = 4,nullable=false)
    private Integer horaAlDia;
    @NotEmpty
    @Range(min=1,max=10)
    @Column(length = 4,nullable=false)
    private Integer diasConvenio;
    @NotEmpty
    @Range(min=2,max=15)
    @Column(length = 4,nullable=false)
    private Integer salarioConvenio;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    
    public Convenio(){

 
   }

    public Convenio(Integer idConvenio, @NotEmpty @Size(min = 1, max = 10) Integer horaConvenio,
            @Size(min = 1, max = 10) Integer horaAlDia, @NotEmpty @Size(min = 1, max = 10) Integer diasConvenio,
            @NotEmpty @Size(min = 2, max = 15) Integer salarioConvenio, Empleado fKempleado) {
        this.idConvenio = idConvenio;
        this.horaConvenio = horaConvenio;
        this.horaAlDia = horaAlDia;
        this.diasConvenio = diasConvenio;
        this.salarioConvenio = salarioConvenio;
        FKempleado = fKempleado;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Integer getHoraConvenio() {
        return horaConvenio;
    }

    public void setHoraConvenio(Integer horaConvenio) {
        this.horaConvenio = horaConvenio;
    }

    public Integer getHoraAlDia() {
        return horaAlDia;
    }

    public void setHoraAlDia(Integer horaAlDia) {
        this.horaAlDia = horaAlDia;
    }

    public Integer getDiasConvenio() {
        return diasConvenio;
    }

    public void setDiasConvenio(Integer diasConvenio) {
        this.diasConvenio = diasConvenio;
    }

    public Integer getSalarioConvenio() {
        return salarioConvenio;
    }

    public void setSalarioConvenio(Integer salarioConvenio) {
        this.salarioConvenio = salarioConvenio;
    }

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

    

   
 }