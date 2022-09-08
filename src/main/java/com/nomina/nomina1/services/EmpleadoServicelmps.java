package com.nomina.nomina1.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.IEmpleado;

@Service
public class EmpleadoServicelmps implements IEmpleadoService{
    
    @Autowired
    private IEmpleado empleadod;
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadod.findAll();
    }

    @Override
    public void save(Empleado empleado) {
        empleadod.save(empleado);
        
    }

    @Override
    public Empleado findOne(Integer idEmpleado) {
        return empleadod.findById(idEmpleado).orElse(null);
    }

    @Override
    public void delete(Integer idEmpleado) {
        empleadod.deleteById(idEmpleado);
    }
    
    private boolean checkUsernameAvailable(Empleado empleado) throws Exception {
        Optional <Empleado> userFound = repository.findByEmailEmpleadoOrDocEmpleadoOrTelEmpleado(empleado.getEmailEmpleado(),empleado.getDocEmpleado(), empleado.getTelEmpleado());
   
   }

}
