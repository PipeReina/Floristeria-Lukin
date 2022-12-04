package com.nomina.nomina1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.IEmpleadoLogin;

@Controller
public class IndexController {
    @Autowired
    public IEmpleadoLogin empleadol;
    
    @GetMapping(path = "/login")
    public String login(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "login";
    }

    @PostMapping("/logear")
    public String logear(@Valid Empleado empleado, BindingResult rest, SessionStatus status){
        Empleado empleados = empleadol.findByDocEmpleado(empleado.getDocEmpleado(), empleado.getPassaword());
        if(empleados==null){
            return "login";
        }
        return "home";
    }
}
