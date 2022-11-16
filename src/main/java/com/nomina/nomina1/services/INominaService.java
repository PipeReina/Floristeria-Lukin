package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Empleado;

public interface INominaService {
    public List<Empleado> findAll();
    public Empleado findOne(Integer idEmpleado);
}
