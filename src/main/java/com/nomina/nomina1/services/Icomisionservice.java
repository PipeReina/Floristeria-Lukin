package com.nomina.nomina1.services;

import java.util.List;
import com.nomina.nomina1.model.comision;
    
    public interface Icomisionservice {

        public List <comision> findAll();
        public void save (comision comision);
        public comision findOne (Integer idComision);
        public void delete (Integer idComision); 
 
}
