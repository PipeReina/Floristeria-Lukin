package com.nomina.nomina1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
    @GetMapping(path = {"/login","/"})
    public String login(Model m){
        m.addAttribute("msn", "Este mensaje viene del controlador");
        return "Login";
    }
}
