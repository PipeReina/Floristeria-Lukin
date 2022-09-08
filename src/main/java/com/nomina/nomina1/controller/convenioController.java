package com.sena.disquera.controllers;

import javax.validation.Valid;

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

import com.sena.disquera.model.convenio;
import com.sena.disquera.service.IConvenioService;
import com.sena.disquera.service.IProyectox;

@Controller
@SessionAttributes("convenio")
@RequestMapping("/convenio")
public class convenioController {
    @Autowired
    private IConvenioService conveniod;
    @Autowired
    private IProyectox disquerad;


    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("convenios", conveniod.findAll());
        return "views/convenio/listarconvenio";    
    }



 @GetMapping("/editar/{id}")
    public String ver(@PathVariable Integer id,Model m){
        convenio alb=null;
        if(id>0){
            alb=conveniod.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("disqueras", disquerad.findAll());
        m.addAttribute("convenio",alb);
        m.addAttribute("accion", "Actualizar convenio");
        return "views/convenio/registrarconvenio";
    }


    @GetMapping("/registrarconvenio")     
    public String form(Model m){
        convenio convenio=new convenio();
        m.addAttribute("convenio",convenio);
        m.addAttribute("disqueras", disquerad.findAll());
         m.addAttribute("accion","agregar convenio");
        return "views/convenio/registrarconvenio"; 
    }
    
    @PostMapping("/add")
    public String add(@Valid convenio convenio,BindingResult res, Model m,SessionStatus
    status){
    if(res.hasErrors()){
        m.addAttribute("disqueras", disquerad.findAll());
    return "convenio/registrarconvenio";
    }
  
    conveniod.save(convenio);
    status.setComplete();
    return "redirect:listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if(id > 0){
            conveniod.delete(id);
            return "redirect:../listar";
        }
        else{
            return "redirect:../listar";
        }

    }

    }
        

    
