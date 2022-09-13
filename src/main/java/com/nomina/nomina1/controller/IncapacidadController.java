package com.nomina.nomina1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;

import com.nomina.nomina1.services.IEmpleadoService;
import com.nomina.nomina1.services.IIncapacidadService;
import com.nomina.nomina1.model.Incapacidad;



@Controller
@SessionAttributes("Incapacidad")
@RequestMapping("/Incapacidad")
public class IncapacidadController {

    @Autowired
    private IIncapacidadService Incapacidadf;
    @Autowired
    private IEmpleadoService empleadod;
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("Incapacidads", Incapacidadf.findAll());
        m.addAttribute("empleado", empleadod.findAll());
        return "Incapacidad/listar";    
    }


    @GetMapping("/verc")
    public String verc(Model m){
        Incapacidad alb=new Incapacidad();
        m.addAttribute("Incapacidad", alb);
        return "Incapacidad/verc";
    }

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nom,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nom);
        return "Incapacidad/ver";
    }*/

    @GetMapping("/edit/{id}")
    public String ver(@PathVariable Integer id,Model m){
        Incapacidad Incapacidad=null;
        if(id>0){
            m.addAttribute("empleado", empleadod.findAll());
            Incapacidad=Incapacidadf.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("empleado", empleadod.findAll());
        m.addAttribute("Incapacidad", Incapacidad);
        m.addAttribute("accion", "Actualizar Incapacidad");
        return "Incapacidad/edit";
    }

    @GetMapping("/form")     
    public String form(Model m){
        Incapacidad Incapacidad=new Incapacidad();
        m.addAttribute("empleados", empleadod.findAll());
        m.addAttribute("Incapacidad", Incapacidad);
        m.addAttribute("accion", "Agregar Incapacidad");
        return "Incapacidad/form"; 
    }


    @PostMapping("/add")
    public String add(@Valid Incapacidad Incapacidad,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
             m.addAttribute("empleado", empleadod.findAll());
            return "Incapacidad/form";
        }
        /*m.addAttribute("Incapacidad",Incapacidad); 
        return "Incapacidad/verc";*/
        Incapacidadf.save(Incapacidad);
        status.setComplete();
        return "redirect:listar";
    }    
    @GetMapping("/estado/{idIncapacidad}")
     public String estado(@PathVariable Integer idIncapacidad,Model m){
         Incapacidad incapacidad=null;
         incapacidad=Incapacidadf.findOne(idIncapacidad);
         if(incapacidad.getEstadoIncapacidad()==true){
             incapacidad.setEstadoIncapacidad(false);
        }else if (incapacidad.getEstadoIncapacidad()==false){
         incapacidad.setEstadoIncapacidad(true);
        }
        Incapacidadf.save(incapacidad);
        return "redirect:../";
     }
     
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			Incapacidadf.delete(id);
		}
		return "redirect:../listar";
	}
}
