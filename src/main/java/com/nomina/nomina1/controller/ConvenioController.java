package com.nomina.nomina1.controller;

import javax.validation.Valid;

import com.nomina.nomina1.model.Convenio;
import com.nomina.nomina1.model.IConvenio;

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
@SessionAttributes("Convenio")
@RequestMapping("/Convenio")
public class ConvenioController {

    @Autowired
    private IConvenio Conveniof;
    @Autowired
    private IEmpleadoService empleadod;
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("Convenios", Conveniof.findAll());
        m.addAttribute("empleado", empleadod.findAll());
        return "Convenio/listar";    
    }


    @GetMapping("/verc")
    public String verc(Model m){
        Convenio alb=new Convenio();
        m.addAttribute("Convenio", alb);
        return "Convenio/verc";
    }

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nom,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nom);
        return "Convenio/ver";
    }*/

    @GetMapping("/ver-Convenio/{id}")
    public String verConvenio(@PathVariable Integer id,Model m){
    Convenio Convenio=null;
    if(id>0){
    Conveniof.findById(id);
    }else{
    return "redirect:listar";
    }
    m.addAttribute("Convenio",Convenio);
    m.addAttribute("accion", "Detalle Convenio");
    return "Convenio/verc";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id,Model m){
        Convenio Convenio=null;
        if(id>0){
            m.addAttribute("empleado", empleadod.findAll());
            Conveniof.findById(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("Convenio",Convenio);
        m.addAttribute("accion", "Actualizar Convenio");
        return "Convenio/form";
    }

    @GetMapping("/form")     
    public String form(Model m){
        Convenio Convenio=new Convenio();
         m.addAttribute("empleado", empleadod.findAll());
        m.addAttribute("Convenio", Convenio);
        m.addAttribute("accion", "Agregar Convenio");
        return "Convenio/form"; 
    }


    @PostMapping("/add")
    public String add(@Valid Convenio Convenio,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
             m.addAttribute("empleado", empleadod.findAll());
            return "Convenio/form";
        }
        /*m.addAttribute("Convenio",Convenio); 
        return "Convenio/verc";*/
        Conveniof.save(Convenio);
        status.setComplete();
        return "redirect:listar";
    }    


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			Conveniof.deleteById(id);
		}
		return "redirect:../listar";
	}
}
