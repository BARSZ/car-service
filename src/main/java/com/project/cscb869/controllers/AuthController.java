package com.project.cscb869.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins={ "http://localhost:3000"})
public class AuthController {
    @GetMapping(value = "/login")
    public String login(){
        return "op";
    }
}
