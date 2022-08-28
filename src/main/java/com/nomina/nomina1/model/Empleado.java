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

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEmpleado")
    private Integer idEmpleado;
    @NotEmpty    
    @Column(name="nombreEmpleado", length=20)
    private String nombreEmpleado;
    @NotEmpty    
    @Column(name="apellidoEmpleado", length=20)
    private String apellidoEmpleado;
    @NotEmpty    
    @Column(name="docEmpleado", length=20)
    private String docEmpleado;
    @NotEmpty    
    @Column(name="epsEmpleado", length=20)
    private String epsEmpleado;
    @NotEmpty    
    @Column(name="direccEmpleado", length = 100)
    private String direccEmpleado;
    @NotEmpty    
    @Column(name="generoEmpleado", length=20)
    private String generoEmpleado;
    @NotEmpty    
    @Column(name="telEmpleado", length=20)
    private String telEmpleado;
    @NotEmpty    
    @Column(name="emailEmpleado", length=100)
    private String emailEmpleado;
    @NotEmpty    
    @Column(name="rhEmpleado", length=20)
    private String rhEmpleado;
    @NotEmpty    
    @Column(name="especialidadEmpleado", length=50)
    private String especialidadEmpleado;
    @NotEmpty    
    @Column(name="fotoEmpleado", length=100000000)
    private String fotoEmpleado;
    @Column(name="estadoEmpleado") 
    private Boolean estadoEmpleado;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo FKcargo;

    public Empleado(){

    }

    public Empleado(Integer idEmpleado, @NotEmpty String nombreEmpleado, @NotEmpty String apellidoEmpleado,
            @NotEmpty String docEmpleado, @NotEmpty String epsEmpleado, @NotEmpty String direccEmpleado,
            @NotEmpty String generoEmpleado, @NotEmpty String telEmpleado, @NotEmpty String emailEmpleado,
            @NotEmpty String rhEmpleado, @NotEmpty String especialidadEmpleado, @NotEmpty String fotoEmpleado,
            Boolean estadoEmpleado, Cargo fKcargo) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.docEmpleado = docEmpleado;
        this.epsEmpleado = epsEmpleado;
        this.direccEmpleado = direccEmpleado;
        this.generoEmpleado = generoEmpleado;
        this.telEmpleado = telEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.rhEmpleado = rhEmpleado;
        this.especialidadEmpleado = especialidadEmpleado;
        this.fotoEmpleado = fotoEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        FKcargo = fKcargo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getDocEmpleado() {
        return docEmpleado;
    }

    public void setDocEmpleado(String docEmpleado) {
        this.docEmpleado = docEmpleado;
    }

    public String getEpsEmpleado() {
        return epsEmpleado;
    }

    public void setEpsEmpleado(String epsEmpleado) {
        this.epsEmpleado = epsEmpleado;
    }

    public String getDireccEmpleado() {
        return direccEmpleado;
    }

    public void setDireccEmpleado(String direccEmpleado) {
        this.direccEmpleado = direccEmpleado;
    }

    public String getGeneroEmpleado() {
        return generoEmpleado;
    }

    public void setGeneroEmpleado(String generoEmpleado) {
        this.generoEmpleado = generoEmpleado;
    }

    public String getTelEmpleado() {
        return telEmpleado;
    }

    public void setTelEmpleado(String telEmpleado) {
        this.telEmpleado = telEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public String getRhEmpleado() {
        return rhEmpleado;
    }

    public void setRhEmpleado(String rhEmpleado) {
        this.rhEmpleado = rhEmpleado;
    }

    public String getEspecialidadEmpleado() {
        return especialidadEmpleado;
    }

    public void setEspecialidadEmpleado(String especialidadEmpleado) {
        this.especialidadEmpleado = especialidadEmpleado;
    }

    public String getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(String fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
    }

    public Boolean getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(Boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Cargo getFKcargo() {
        return FKcargo;
    }

    public void setFKcargo(Cargo fKcargo) {
        FKcargo = fKcargo;
    }



    
}