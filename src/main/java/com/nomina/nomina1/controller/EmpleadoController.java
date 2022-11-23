package com.nomina.nomina1.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.services.IEmpleadoService;

import org.springframework.ui.Model;


@Controller
@SessionAttributes("empleado")
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadod;

    // @Autowired
    // private ICargoService cargod;

    @GetMapping(path = {"/","empleado"})
    public String listar(Model m){
        // m.addAttribute("cargos", cargod.findAll());
        m.addAttribute("empleado", empleadod.findAll());
        return "empleado/empleado";
    }

    
    @GetMapping("/edit/{idEmpleado}")
     public String ver(@PathVariable Integer idEmpleado,Model m){
         Empleado empleado=null;
         if(idEmpleado>0){
            // m.addAttribute("cargos", cargod.findAll());
            empleado=empleadod.findOne(idEmpleado);
         }else{
             return "redirect:empleado";
         }
        //  m.addAttribute("cargos", cargod.findAll());
         m.addAttribute("empleado",empleado);
         return "empleado/edit";
     }

     @GetMapping("/crear")     
    public String creacion(Model m){
        Empleado empleado=new Empleado();
        // m.addAttribute("cargos", cargod.findAll());
        m.addAttribute("empleado", empleado);
        m.addAttribute("accion", "Agregar empleado");
        return "empleado/creacion"; 
    }
    @PostMapping("/add")
        public String add(@Valid Empleado empleado,BindingResult res, Model m,@RequestParam("fotoEmpleado") MultipartFile imagen, SessionStatus status){
            if(!res.hasErrors()){
                System.out.println(res.hasErrors());
                //  m.addAttribute("cargos", cargod.findAll());
                m.addAttribute("empleado", empleado);
                return "empleado/creacion";
            }
            if(!imagen.isEmpty()){
                Path director=Paths.get("src//main//resources//static//img");
                String rutaAbs=director.toFile().getAbsolutePath();

                try {
                    byte[] bytesImg = imagen.getBytes();
                    Path rutaCompleta=Paths.get(rutaAbs + "//"+ imagen.getOriginalFilename());
                    Files.write(rutaCompleta, bytesImg);

                // empleado.setFotoEmpleado(imagen.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            empleadod.save(empleado);
            status.setComplete();
            return "redirect:empleado";
        }

     @GetMapping("/estado/{idEmpleado}")
     public String estado(@PathVariable Integer idEmpleado,Model m){
         Empleado empleado=null;
         empleado=empleadod.findOne(idEmpleado);
         if(empleado.getEstadoEmpleado()==true){
            empleado.setEstadoEmpleado(false);
        }else if (empleado.getEstadoEmpleado()==false){
            empleado.setEstadoEmpleado(true);
        }
        empleadod.save(empleado);
        return "redirect:../";
     }

     @GetMapping("/eliminar/{idEmpleado}")
     public String eliminar(@PathVariable Integer idEmpleado){
         if(idEmpleado>0){
             empleadod.delete(idEmpleado);
         }
         return "redirect:../";
 }


}
