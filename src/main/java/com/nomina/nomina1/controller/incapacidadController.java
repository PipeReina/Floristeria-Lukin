package com.sena.disquera.controllers;


import javax.validation.Valid;

import com.sena.disquera.model.incapacidad;
import com.sena.disquera.service.IConvenioService;

import com.sena.disquera.service.iincapacidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes("incapacidad")
@RequestMapping("/incapacidad")
public class incapacidadController {
    @Autowired
    private iincapacidadService incapacidadd;
    @Autowired
    private IConvenioService artistad;
    @Autowired
    private IGeneroService generod;

   

    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("incapacidades", incapacidadd.findAll());
        return "views/incapacidad/listarincapacidad";    
    }



 @GetMapping("/editar/{id}")
    public String ver(@PathVariable Integer id,Model m){
        incapacidad alb=null;
        if(id>0){
            alb=incapacidadd.findOne(id);
        }else{
            m.addAttribute("artistas", artistad.findAll());
            m.addAttribute("generos", generod.findAll());
            return "redirect:listar";
        }
        m.addAttribute("artistas", artistad.findAll());
        m.addAttribute("generos", generod.findAll());
        m.addAttribute("incapacidad",alb);
        m.addAttribute("accion", "Actualizar incapacidad");
        return "views/incapacidad/registrarincapacidad";
    }


    @GetMapping("/registrarincapacidad")     
    public String form(Model m){
        incapacidad incapacidad=new incapacidad();
        m.addAttribute("incapacidad",incapacidad);
         m.addAttribute("accion","agregar incapacidad");
         m.addAttribute("artistas", artistad.findAll());
         m.addAttribute("generos", generod.findAll());
        return "views/incapacidad/registrarincapacidad"; 
    }
    
    @PostMapping("/add")
    public String add(@Valid incapacidad incapacidad,BindingResult res, Model m,SessionStatus
    status){
    if(res.hasErrors()){
    return "incapacidad/registrarincapacidad";
    }
  
    incapacidadd.save(incapacidad);
    status.setComplete();
    return "redirect:listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id > 0){
            incapacidadd.delete(id);
            return "redirect:../listar";
        }
        else{
            return "redirect:../listar";
        }

    }

    }
        

    
    


