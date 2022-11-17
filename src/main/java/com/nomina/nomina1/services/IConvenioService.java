package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Convenio;

public interface IConvenioService {
    public List<Convenio> findAll();
    public void save (Convenio Convenio);
    public Convenio findOne(Integer idDev);
    public void delete(Integer idDev);
}