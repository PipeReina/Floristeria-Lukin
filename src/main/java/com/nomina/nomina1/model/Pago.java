package com.nomina.nomina1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Size(min=10,max=10)
    @Column(length = 4,nullable=false)
    private String fecha;
    /*@OneToMany(mappedBy = "pagos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Devengado> devengados;
	
	public void setdevengados(List<Devengado> devengados) {
		this.devengados = devengados;
	}
    */

    //Constructores
    public Pago() {
    }

    public Pago(Integer id, @NotEmpty @Size(min = 4, max = 4) String fecha/*, List<Devengado> devengados*/) {
        this.id = id;
        this.fecha = fecha;
        /*this.devengados = devengados;*/
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }  


}
