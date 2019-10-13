package edu.mum.cs.cs425.hospitalmgt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/hcmc/home"})
    public String displayHomePage(){
        return "home/index";
    }
}
