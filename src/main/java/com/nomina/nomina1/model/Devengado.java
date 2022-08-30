
package com.nomina.nomina1.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
@Table(name="devengados")
public class Devengado {
        //atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idDevengado;
        @NotEmpty    
        @Column(name="TotalDevengado", length=20)
        private Integer totalDevengado;
        @NotEmpty    
        @Column(name="fechaDevengado", length=20)   
        private String fechaDevengado;
        @Column(name="estadoDevengado") 
        private Boolean estado;
        @ManyToOne(fetch = FetchType.LAZY)
        private Empleado FKempleado;

        //constructores
        public Devengado() {
        }

        public Devengado(Integer idDevengado, @NotEmpty Integer totalDevengado, @NotEmpty String fechaDevengado,
                Boolean estado, Empleado fKempleado) {
            this.idDevengado = idDevengado;
            this.totalDevengado = totalDevengado;
            this.fechaDevengado = fechaDevengado;
            this.estado = estado;
            FKempleado = fKempleado;
        }

        public Integer getIdDevengado() {
            return idDevengado;
        }

        public void setIdDevengado(Integer idDevengado) {
            this.idDevengado = idDevengado;
        }

        public Integer getTotalDevengado() {
            return totalDevengado;
        }

        public void setTotalDevengado(Integer totalDevengado) {
            this.totalDevengado = totalDevengado;
        }

        public String getFechaDevengado() {
            return fechaDevengado;
        }

        public void setFechaDevengado(String fechaDevengado) {
            this.fechaDevengado = fechaDevengado;
        }

        public Boolean getEstado() {
            return estado;
        }

        public void setEstado(Boolean estado) {
            this.estado = estado;
        }

        public Empleado getFKempleado() {
            return FKempleado;
        }

        public void setFKempleado(Empleado fKempleado) {
            FKempleado = fKempleado;
        }

        

        
    
}
