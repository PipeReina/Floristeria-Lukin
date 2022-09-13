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

@Entity
@Table(name="convenio")
public class Convenio {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConvenio;
    @NotEmpty
    @Size(min=1,max=10)
    @Column(length = 4,nullable=false)
    private String horaConvenio;
    @NotEmpty
    @Size(min=1,max=10)
    @Column(length = 4,nullable=false)
    private String diasConvenio;
    @NotEmpty
    @Size(min=2,max=15)
    @Column(length = 4,nullable=false)
    private String salarioConvenio;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    
    public Convenio(){

    }

    public Convenio(Integer idConvenio, @NotEmpty @Size(min = 1, max = 10) String horaConvenio,
            @NotEmpty @Size(min = 1, max = 10) String diasConvenio,
            @NotEmpty @Size(min = 6, max = 15) String salarioConvenio, Empleado fKempleado) {
        this.idConvenio = idConvenio;
        this.horaConvenio = horaConvenio;
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

    public String getHoraConvenio() {
        return horaConvenio;
    }

    public void setHoraConvenio(String horaConvenio) {
        this.horaConvenio = horaConvenio;
    }

    public String getDiasConvenio() {
        return diasConvenio;
    }

    public void setDiasConvenio(String diasConvenio) {
        this.diasConvenio = diasConvenio;
    }

    public String getSalarioConvenio() {
        return salarioConvenio;
    }

    public void setSalarioConvenio(String salarioConvenio) {
        this.salarioConvenio = salarioConvenio;
    }

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

}