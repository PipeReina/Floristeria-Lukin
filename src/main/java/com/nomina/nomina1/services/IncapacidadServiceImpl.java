package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Incapacidad;
import com.nomina.nomina1.model.IIncapacidad;

@Service
public class IncapacidadServiceImpl implements IIncapacidadService{

    @Autowired
    private IIncapacidad Incapacidadf;

    @Override
    public List<Incapacidad> findAll() {
        return (List<Incapacidad>) Incapacidadf.findAll();
    }

    @Override
    public void save(Incapacidad Incapacidad) {
        Incapacidadf.save(Incapacidad);
        
    }

    @Override
    public Incapacidad findOne(Integer idIncapacidad) {
        return Incapacidadf.findById(idIncapacidad).orElse(null);
    }

    @Override
    public void delete(Integer idIncapacidad) {
        Incapacidadf.deleteById(idIncapacidad);
    }
}
