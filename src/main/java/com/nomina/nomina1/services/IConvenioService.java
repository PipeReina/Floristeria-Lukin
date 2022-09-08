package com.sena.disquera.service;

import java.util.List;

import com.sena.disquera.model.convenio;

    public interface IConvenioService {
        public List<convenio> findAll();
        public void save (convenio convenio);
        public convenio findOne(Integer id);
        public void delete(Integer id);
}
