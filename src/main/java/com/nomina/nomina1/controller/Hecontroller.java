package com.nomina.nomina1.controller;

import javax.validation.Valid;
import com.nomina.nomina1.model.he;
import com.nomina.nomina1.services.heserviceimpl;

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
@SessionAttributes("he")
@RequestMapping("/he")
public class Hecontroller {
    
    @Autowired
    private IEmpleadoService empleadod;

    @Autowired
    private heserviceimpl het;

    @GetMapping(path={"/listarhe","","/"})
    public String listarhe(Model mo){
        mo.addAttribute("empleado", empleadod.findAll());
        mo.addAttribute("hse", het.findAll());
        he he = new he();
        mo.addAttribute("he", he);
        mo.addAttribute("accion", "Agregar horas extra");
    
        System.out.println(mo);
        return "he/listar";
    }

    @GetMapping("/verhe")
    public String verhe(Model mo){
        he horase = new he();
        mo.addAttribute("he",horase);
        return "he/verhe";
    }

    @GetMapping("/edit/{idHorasExtra}")
    public String edit(@PathVariable Integer idHorasExtra,Model mo){
        he he = null;
        if(idHorasExtra>0){
            he = het.findOne(idHorasExtra);
        }else{
            return "redirect:listarhe";
        }
        mo.addAttribute("he",he);
        mo.addAttribute("accion","Actualizar Horas Extra");
        return "he/edit";  
    }  


    @PostMapping("/add")
    public String add(@Valid he he, BindingResult res, Model mo, SessionStatus status){
        if(res.hasErrors()){
            mo.addAttribute("empleado", empleadod.findAll());
            return "he/listar";
        }
        het.save(he);
        status.setComplete();
        return "redirect:listarhe";
    }

    @GetMapping("/estado/{idHorasExtra}")
    public String estado(@PathVariable Integer idHorasExtra,Model mo){
        he he=null;
        he=het.findOne(idHorasExtra);
        if(he.getEstadoHE()==true){
           he.setEstadoHE(false);
       }else if (he.getEstadoHE()==false){
           he.setEstadoHE(true);
       }
       het.save(he);
       return "redirect:../";
    }

    @GetMapping("delete/{idHorasExtra}")
    public String delete (@PathVariable Integer idHorasExtra){
        if(idHorasExtra > 0){
            het.delete(idHorasExtra);
        }
        return "redirect:../listarhe";
    }
}
