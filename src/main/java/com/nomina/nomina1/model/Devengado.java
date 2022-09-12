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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="devengados")
public class Devengado {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Double total;
    @NotEmpty
    @Size(min=10,max=10)
    @Column(length = 4,nullable=false)
    private String fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado FKempleado;
    
    @OneToMany(mappedBy = "FKdevengado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pago> FKpago;

    public Devengado(){
        FKpago=new ArrayList<Pago>();
    }

    public Devengado(Integer id, @NotNull Double total, @NotEmpty @Size(min = 10, max = 10) String fecha,
            Empleado fKempleado, List<Pago> fKpago) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        FKempleado = fKempleado;
        FKpago = fKpago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getFKempleado() {
        return FKempleado;
    }

    public void setFKempleado(Empleado fKempleado) {
        FKempleado = fKempleado;
    }

    public List<Pago> getFKpago() {
        return FKpago;
    }

    public void setFKpago(List<Pago> fKpago) {
        FKpago = fKpago;
    }

    
}