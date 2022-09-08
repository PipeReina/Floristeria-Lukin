package com.nomina.nomina1.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface IEmpleado extends CrudRepository<Empleado,Integer>{
    public Optional <Empleado> findByEmailEmpleadoOrDocEmpleadoOrTelEmpleado(String emailEmpleado, String docEmpleado, String telEmpleado );
}
