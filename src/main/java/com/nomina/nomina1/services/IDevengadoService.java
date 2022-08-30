package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Devengado;

public interface IDevengadoService {
    public List<Devengado> findAll();
    public void save (Devengado Devengado);
    public Devengado findOne(Integer id);
    public void delete(Integer id);
}