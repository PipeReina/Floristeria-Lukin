package com.nomina.nomina1.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// import org.springframework.lang.NonNull;

@Entity
@Table(name="pago")
public class Pago {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;
    // @NonNull
    @NotNull
    @Column(length = 10)
    @Size (min=2, max=20)
    private String fechaPago;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleadoFK")
    private Empleado empleadoFK;
    
    public Pago() {
    }

    public Pago(Integer idPago, @NotNull @Size(min = 2, max = 10) String fechaPago, Empleado empleadoFK) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.empleadoFK = empleadoFK;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Empleado getEmpleadoFK() {
        return empleadoFK;
    }

    public void setEmpleadoFK(Empleado empleadoFK) {
        this.empleadoFK = empleadoFK;
    }

    
}