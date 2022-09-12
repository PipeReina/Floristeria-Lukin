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
@Table(name="pagos")
public class Pago {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(length = 10)
    @Size (min=2, max=10)
    private String fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pago FKdevengado;
    
    public Pago() {
    }    

    public Pago(Integer id, @NotEmpty @Size(min = 2, max = 10) String fecha, Pago fKdevengado) {
        this.id = id;
        this.fecha = fecha;
        FKdevengado = fKdevengado;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Pago getFKdevengado() {
        return FKdevengado;
    }

    public void setFKdevengado(Pago fKdevengado) {
        FKdevengado = fKdevengado;
    }
}