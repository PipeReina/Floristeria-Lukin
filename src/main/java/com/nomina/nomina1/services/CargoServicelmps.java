package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Cargo;
import com.nomina.nomina1.model.ICargo;

@Service
public class CargoServicelmps implements ICargoService{

    @Autowired
    private ICargo cargod;
    @Override
    public List<Cargo> findAll() {
        return (List<Cargo>) cargod.findAll();
    }

    @Override
    public void save(Cargo cargo) {
        cargod.save(cargo);
        
    }

    @Override
    public Cargo findOne(Integer idCargo) {
        return cargod.findById(idCargo).orElse(null);
    }

    @Override
    public void delete(Integer idCargo) {
        cargod.deleteById(idCargo);
    }
    
}
