package com.nomina.nomina1.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface IEmpleado extends CrudRepository<Empleado,Integer>{
    public Optional <Empleado> findByEmailEmpleado(String emailEmpleado);
    public Optional <Empleado> findByDocEmpleado(String docEmpleado);
    public Optional <Empleado> findByTelEmpleado(String telEmpleado );
}
