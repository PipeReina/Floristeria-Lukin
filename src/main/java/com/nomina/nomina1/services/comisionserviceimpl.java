package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Icomision;
import com.nomina.nomina1.model.comision;

@Service
public class comisionserviceimpl implements Icomisionservice {
    
    @Autowired
    private Icomision com;

    @Override
    public List <comision> findAll(){
        return(List<comision>)com.findAll();
    }
    
    @Override
    public comision findOne(Integer idComision){
        return com.findById(idComision).orElse(null);
    }

    @Override
    public void save(comision comision){
        com.save(comision);
    }

    @Override
    public void delete (Integer idComision){
        com.deleteById(idComision);

    }

    
}
