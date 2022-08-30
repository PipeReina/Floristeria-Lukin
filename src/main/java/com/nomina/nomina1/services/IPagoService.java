package com.nomina.nomina1.services;

import java.util.List;

import com.nomina.nomina1.model.Pago;


public interface IPagoService {
    public List<Pago> findAll();
    public void save (Pago Pago);
    public Pago findOne(Integer id);
    public void delete(Integer id);
}