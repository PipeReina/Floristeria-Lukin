package com.nomina.nomina1.controller;

import javax.validation.Valid;

import com.nomina.nomina1.model.Devengado;
import com.nomina.nomina1.model.IDevengado;

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
@SessionAttributes("Devengado")
@RequestMapping("/Devengado")
public class DevengadoController {

    @Autowired
    private IDevengado Devengadof;
    
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("Devengados", Devengadof.findAll());
        return "Devengado/listar";    
    }


    @GetMapping("/verc")
    public String verc(Model m){
        Devengado alb=new Devengado();
        m.addAttribute("Devengado", alb);
        return "Devengado/verc";
    }

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nom,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nom);
        return "Devengado/ver";
    }*/

    @GetMapping("/ver-Devengado/{id}")
    public String verDevengado(@PathVariable Integer id,Model m){
    Devengado Devengado=null;
    if(id>0){
    Devengadof.findById(id);
    }else{
    return "redirect:listar";
    }
    m.addAttribute("Devengado",Devengado);
    m.addAttribute("accion", "Detalle Devengado");
    return "Devengado/verc";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id,Model m){
        Devengado Devengado=null;
        if(id>0){
            Devengadof.findById(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("Devengado",Devengado);
        m.addAttribute("accion", "Actualizar Devengado");
        return "Devengado/form";
    }

    @GetMapping("/form")     
    public String form(Model m){
        Devengado Devengado=new Devengado();
        m.addAttribute("Devengado", Devengado);
        m.addAttribute("accion", "Agregar Devengado");
        return "Devengado/form"; 
    }


    @PostMapping("/add")
    public String add(@Valid Devengado Devengado,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
            return "Devengado/form";
        }
        /*m.addAttribute("Devengado",Devengado); 
        return "Devengado/verc";*/
        Devengadof.save(Devengado);
        status.setComplete();
        return "redirect:listar";
    }    


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			Devengadof.deleteById(id);
		}
		return "redirect:../listar";
	}
}
