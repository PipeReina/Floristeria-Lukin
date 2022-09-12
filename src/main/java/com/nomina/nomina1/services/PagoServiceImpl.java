package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Pago;
import com.nomina.nomina1.model.IPago;

@Service
public class PagoServiceImpl implements IPagoService{

    @Autowired
    private IPago Pagof;

    @Override
    public List<Pago> findAll() {
        return (List<Pago>) Pagof.findAll();
    }

    @Override
    public void save(Pago Pago) {
        Pagof.save(Pago);
        
    }

    @Override
    public Pago findOne(Integer idPago) {
        return Pagof.findById(idPago).orElse(null);
    }

    @Override
    public void delete(Integer idPago) {
        Pagof.deleteById(idPago);
    }
}
