package com.nomina.nomina1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.IEmpleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
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

    /*@Override
    public void createEmpleado(Empleado empleado) throws Exception {
        empleadod.save(empleado);
    }

    @Override
    public Empleado findByDocEmpleado(String docEmpleado) {
        return null;
    }*/
    
    @Autowired
    public IEmpleado repo;

    private boolean checkEmailAvailable(Empleado empleado) throws Exception{
        Empleado docEmpleado=empleadod.findByDocEmpleado(empleado.getDocEmpleado());
        if (docEmpleado!=null) {
            throw new Exception("Email no disponible");
        }
        return true;
    }
    
    @Override
    public Empleado createEmpleado(Empleado empleado) throws Exception {
        if (checkEmailAvailable(empleado)) {
            empleado.setPassword(passwordEncoder.encode(empleado.getPassword()));
            empleado = empleadod.save(empleado);
        }
        return empleado;
    }

    @Override
    public Empleado findByDocEmpleado(String docEmpleado) {
        return empleadod.findByDocEmpleado(docEmpleado);
    }
}
