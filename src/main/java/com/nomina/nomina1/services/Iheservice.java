package com.nomina.nomina1.services;

import java.util.List;
import com.nomina.nomina1.model.he;

public interface Iheservice {
       
    public List <he> findAll();
    public void save (he he);
    public he findOne (Integer idHorasExtra);
    public void delete (Integer idHorasExtra); 
}