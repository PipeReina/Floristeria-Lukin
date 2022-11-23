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

import com.nomina.nomina1.model.Cargo;
import com.nomina.nomina1.services.ICargoService;

import org.springframework.ui.Model;


@Controller
@SessionAttributes("cargo")
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private ICargoService cargod;


    @GetMapping(path = {"/","cargo"})
    public String listar(Model m){
        m.addAttribute("cargo", cargod.findAll());
        return "cargo/cargo";
    }

    
    @GetMapping("/edit/{idCargo}")
     public String ver(@PathVariable Integer idCargo,Model m){
         Cargo cargo=null;
         if(idCargo>0){
            cargo=cargod.findOne(idCargo);
         }else{
             return "redirect:";
         }
         m.addAttribute("cargo",cargo);
         return "cargo/edit";
     }
    @GetMapping("/crear")     
    public String creacion(Model m){
        Cargo cargo=new Cargo();
        m.addAttribute("cargo", cargo);
        m.addAttribute("accion", "Agregar cargo");
        return "cargo/creacion"; 
    }
    @PostMapping("/add")
        public String add(@Valid Cargo cargo,BindingResult res, Model m,SessionStatus status){
            if(res.hasErrors()){
                return "cargo/creacion";
            }
            cargod.save(cargo);
            status.setComplete();
            return "redirect:cargo";
        }
     @GetMapping("/estado/{idCargo}")
     public String estado(@PathVariable Integer idCargo,Model m){
         Cargo cargo=null;
         cargo=cargod.findOne(idCargo);
         if(cargo.getEstadoCargo()==true){
            cargo.setEstadoCargo(false);
        }else if (cargo.getEstadoCargo()==false){
            cargo.setEstadoCargo(true);
        }
        cargod.save(cargo);
       return "redirect:../";
     }

     @GetMapping("/eliminar/{idCargo}")
     public String eliminar(@PathVariable Integer idCargo){
         if(idCargo>0){
             cargod.delete(idCargo);
         }
         return "redirect:../";
 }


}
