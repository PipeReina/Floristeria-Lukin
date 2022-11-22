package com.nomina.nomina1.controller;


import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {
    @RequestMapping("/**")
    public String handleError() {
        return "/error404";
    }
}
