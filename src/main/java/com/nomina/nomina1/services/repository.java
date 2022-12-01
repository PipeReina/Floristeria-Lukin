package com.nomina.nomina1.services;

import java.util.Optional;

import com.nomina.nomina1.model.Empleado;

public interface repository {

    static Optional<Empleado> findByEmailEmpleado(String emailEmpleado) {
        return null;
    }

    static Optional<Empleado> findByDocEmpleado(String docEmpleado) {
        return null;
    }

    static Optional<Empleado> findByTelEmpleado(String telEmpleado) {
        return null;
    }

}
