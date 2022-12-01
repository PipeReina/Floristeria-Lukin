package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Convenio;
import com.nomina.nomina1.model.IConvenio;

@Service
public class ConvenioServiceImpl implements IConvenioService{

    @Autowired
    private IConvenio Conveniof;

    @Override
    public List<Convenio> findAll() {
        return (List<Convenio>) Conveniof.findAll();
    }

    @Override
    public void save(Convenio Convenio) {
        Conveniof.save(Convenio);
        
    }

    @Override
    public Convenio findOne(Integer idDev) {
        return Conveniof.findById(idDev).orElse(null);
    }

    @Override
    public void delete(Integer idDev) {
        Conveniof.deleteById(idDev);
    }
}
