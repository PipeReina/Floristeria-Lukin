package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Empleado;

public interface IEmpleadoService {
    public List<Empleado> findAll();
    public void save (Empleado empleado);
    public Empleado findOne (Integer idEmpleado);
    public void delete (Integer idEmpleado);
}
