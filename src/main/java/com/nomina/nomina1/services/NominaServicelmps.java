package com.nomina.nomina1.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.INomina;

@Service
public class NominaServicelmps implements INominaService{

    @Autowired
    private INomina nomi;

    @Override
    public List<Empleado> findAll() {

        return (List<Empleado>) nomi.findAll();
    }

    @Override
    public Empleado findOne(Integer idEmpleado) {
        return nomi.findById(idEmpleado).orElse(null);
    }
    
}
