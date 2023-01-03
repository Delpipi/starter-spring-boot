package com.balietek.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

    @GetMapping(value="hello")
    public String greeting(){
        return "Hello world";
    }
    
}
