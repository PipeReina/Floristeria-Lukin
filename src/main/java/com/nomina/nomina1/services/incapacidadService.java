package com.sena.disquera.service;

import java.util.List;

import com.sena.disquera.model.incapacidad;

    public interface incapacidadService {
        public List<incapacidad> findAll();
        public void save (incapacidad incapacidad);
        public incapacidad findOne(Integer id);
        public void delete(Integer id);
}
