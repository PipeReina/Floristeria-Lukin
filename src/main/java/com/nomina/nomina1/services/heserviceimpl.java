package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Ihe;
import com.nomina.nomina1.model.he;

@Service
public class heserviceimpl implements Iheservice {
    
    @Autowired
    private Ihe het;

    @Override
    public List <he> findAll(){
        return(List<he>)het.findAll();
    }
    
    @Override
    public he findOne(Integer idHorasExtra){
        return het.findById(idHorasExtra).orElse(null);
    }

    @Override
    public void save(he he){
        het.save(he);
    }

    @Override
    public void delete (Integer idHorasExtra){
        het.deleteById(idHorasExtra);

    }

    
}

