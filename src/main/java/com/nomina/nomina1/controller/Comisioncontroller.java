package com.nomina.nomina1.controller;

import javax.validation.Valid;
import com.nomina.nomina1.model.comision;
import com.nomina.nomina1.services.Icomisionservice;
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
import com.nomina.nomina1.services.IEmpleadoService;


@Controller
@SessionAttributes("comision")
@RequestMapping("/comision")

public class Comisioncontroller {

    @Autowired
    private IEmpleadoService empleadod;

    @Autowired
    private Icomisionservice com;

    @GetMapping(path={"/listarcom","","/"})
    public String listarcom(Model mo){
        mo.addAttribute("comisiones", com.findAll());
        return "comision/listarcom";
    }
 
    @GetMapping("/vercom")
    public String vercom(Model mo){
        comision comi = new comision();
        comi.setIdComision(1); 
        mo.addAttribute("comision",comi);
        return "comision/vercom";
    }

    @GetMapping("/buscarcom/{idComision}")
    public String buscarcom(@PathVariable Integer idComision,Model mo){
        comision comision = null;
        if(idComision>0){
            comision = com.findOne(idComision);
        }else{
            return "redirect:listarcom";
        }
        mo.addAttribute("comision",comision);
        mo.addAttribute("accion");
        return "comision/formcom";  
    }  

    @GetMapping("/formcom")
    public String formcom(Model mo){
        comision comision = new comision();
        mo.addAttribute("comision", comision);
        mo.addAttribute("empleado", empleadod.findAll());
        mo.addAttribute("accion");
        return "comision/formcom";
    }

    @PostMapping("add")
    public String add(@Valid comision comision, BindingResult res, Model mo, SessionStatus status){
        if(res.hasErrors()){
            return "comision/formcom";
        }
        com.save(comision);
        status.setComplete();
        return "redirect:listarcom";
    }

    @GetMapping("/estado/{idComision}")
    public String estado(@PathVariable Integer idComision,Model mo){
        comision comision=null;
        comision=com.findOne(idComision);
        if(comision.getEstadoCom()==true){
           comision.setEstadoCom(false);
       }else if (comision.getEstadoCom()==false){
           comision.setEstadoCom(true);
       }
       com.save(comision);
       return "redirect:../";
    }



    @GetMapping("/delete/{idComision}")
    public String delete (@PathVariable Integer idComision){
        if(idComision > 0){
            com.delete(idComision);
        }
        return "redirect:../listarcom";
    }
}
