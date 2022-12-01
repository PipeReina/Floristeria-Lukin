package com.nomina.nomina1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(path = {"/","","/index","/home"})
    public String index(Model m){
        m.addAttribute("msn", "Este mensaje viene del controlador");
        return "Home";
    }

}
