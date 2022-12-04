package com.nomina.nomina1.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpleadoLogin extends JpaRepository<Empleado,Integer>{
    
    @Query(value = "select * from empleado e where e.doc_empleado=?1 and e.password=?2", nativeQuery = true)
    public Empleado findByDocEmpleado(String docEmpleado, String password);

}
