package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Cargo;

public interface ICargoService {
    public List<Cargo> findAll();
    public void save (Cargo cargo);
    public Cargo findOne (Integer idCargo);
    public void delete (Integer idCargo);
    
}
