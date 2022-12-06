package com.nomina.nomina1.controller;


import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.support.SessionStatus;

import com.nomina.nomina1.model.Empleado;
//import com.nomina.nomina1.model.IEmpleado;
//import com.nomina.nomina1.model.IEmpleadoLogin;
import com.nomina.nomina1.services.EmpleadoServiceImpl;


@Controller
public class IndexController {

    /*@Autowired
    public IEmpleadoLogin empleadol;
    @GetMapping(path = {"/","","/login"})
    public String loger(Model m){
        return "login";
    }*/

    @GetMapping(path = "/login")
    public String login(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "login";
    }

    /*@PostMapping("/logear")
    public String logear(@Valid Empleado empleado, BindingResult rest, SessionStatus status){
        Empleado empleados = empleadol.findByDocEmpleado(empleado.getDocEmpleado(), empleado.getPassword());
        if(empleados==null){
            return "login";
        }
        return "home";
    }*/

    @Autowired
    private EmpleadoServiceImpl empleadod;

    @GetMapping(path = "/home")
    public String home(Authentication auth, HttpSession session) {
        System.out.println(auth);
        String username = auth.getName();

        if (session.getAttribute("empleado") == null) {
            Empleado empleado = empleadod.findByDocEmpleado(username);
            empleado.setPassword(null);
            session.setAttribute("empleado", empleado);
        }
        return "home";
    }
}
