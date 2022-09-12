package com.nomina.nomina1.controller;

//import java.util.List;

import javax.validation.Valid;

import com.nomina.nomina1.model.Pago;
//import com.nomina.nomina1.model.Pago;
import com.nomina.nomina1.model.IPago;
//import com.nomina.nomina1.service.IPagoService;

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
@SessionAttributes("Pago")
@RequestMapping("/Pago")
public class PagoController {

    @Autowired
    private IPago Pagof;
    //@Autowired
    //private IPagoService Pagof;
    
    
    @GetMapping(path={"/listar","","/"})
    public String listar(Model m){
        m.addAttribute("Pagos", Pagof.findAll());
        return "Pago/listar";    
    }


    /*@GetMapping("/verc")
    public String verc(Model m){
        Pago alb=new Pago();
        alb.setId(1);
        alb.setNombre("Jennifer");
        m.addAttribute("Pago", alb);
        return "Pago/verc";
    }*/

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nom,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nom);
        return "Pago/ver";
    }*/


    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id,Model m){
        Pago Pago=null;
        if(id>0){
            Pagof.findById(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("Pago",Pago);
        m.addAttribute("accion", "Actualizar Pago");
        return "Pago/form";
    }

    @GetMapping("/form")     
    public String form(Model m){
        Pago Pago=new Pago();
        m.addAttribute("Pago", Pago);
        m.addAttribute("accion", "Agregar Pago");
        return "Pago/form"; 
    }


    @PostMapping("/add")
    public String add(@Valid Pago Pago,BindingResult res, Model m,SessionStatus status){
        if(res.hasErrors()){
            return "Pago/form";
        }
        Pagof.save(Pago);
        status.setComplete();
        return "redirect:listar";
    }   


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
		
		if(id > 0) {
			Pagof.deleteById(id);
		}
		return "redirect:../listar";
	}
}
