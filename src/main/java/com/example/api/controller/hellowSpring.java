package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// funcionalidade simples criada como exemplo.
@RestController
@RequestMapping("/hello")
public class hellowSpring {

    @GetMapping
    public String OlaMundO(){
        return "Hello World Spring Agita";

    }

}
