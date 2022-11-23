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

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="convenio")
public class Convenio {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConvenio;

    @Column(length = 10,nullable=false)
    private Integer horaConvenio;

    @Column(length = 10,nullable=false)
    private Integer horaAlDia;

    @Column(length = 10,nullable=false)
    private Integer diasConvenio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    
    public Convenio(){

 
   }

   

    public Convenio(Integer idConvenio, @Range(min = 0, max = 10) Integer horaConvenio,
            @Range(min = 0, max = 10) Integer horaAlDia, @Range(min = 0, max = 10) Integer diasConvenio,
            Empleado fKempleado) {
        this.idConvenio = idConvenio;
        this.horaConvenio = horaConvenio;
        this.horaAlDia = horaAlDia;
        this.diasConvenio = diasConvenio;
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

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

   

   
 }