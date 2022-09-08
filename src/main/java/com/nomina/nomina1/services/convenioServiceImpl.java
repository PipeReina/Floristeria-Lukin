package com.sena.disquera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disquera.model.convenio;
import com.sena.disquera.model.iConvenio;

@Service
public class convenioServiceImpl implements IConvenioService {
    @Autowired
private iConvenio conveniod;
   
    
    @Override
public List<convenio> findAll() {
return (List<convenio>) conveniod.findAll();
}
@Override
public convenio findOne(Integer id) {
return conveniod.findById(id).orElse(null);
}
public void save(convenio convenio) {
    conveniod.save(convenio);
    }
    @Override
public void delete(Integer id) {
conveniod.deleteById(id);
}
}

