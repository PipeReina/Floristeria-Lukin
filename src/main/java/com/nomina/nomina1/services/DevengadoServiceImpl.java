package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Devengado;
import com.nomina.nomina1.model.IDevengado;

@Service
public class DevengadoServiceImpl implements IDevengadoService{

    @Autowired
    private IDevengado Devengadof;

    @Override
    public List<Devengado> findAll() {
        return (List<Devengado>) Devengadof.findAll();
    }

    @Override
    public void save(Devengado Devengado) {
        Devengadof.save(Devengado);
        
    }

    @Override
    public Devengado findOne(Integer id) {
        return Devengadof.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Devengadof.deleteById(id);
    }
}
