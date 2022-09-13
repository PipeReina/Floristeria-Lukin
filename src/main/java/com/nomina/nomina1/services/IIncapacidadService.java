package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Incapacidad;

public interface IIncapacidadService {
    public List<Incapacidad> findAll();
    public void save (Incapacidad Incapacidad);
    public Incapacidad findOne(Integer idIncapacidad);
    public void delete(Integer idIncapacidad);
}