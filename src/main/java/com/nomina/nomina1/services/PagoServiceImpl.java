package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.IPago;
import com.nomina.nomina1.model.Pago;



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
    public Pago findOne(Integer id) {
        return Pagof.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Pagof.deleteById(id);
    }
}
