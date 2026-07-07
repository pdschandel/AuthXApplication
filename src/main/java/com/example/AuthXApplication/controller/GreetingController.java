package com.example.AuthXApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String greetings(){
        return "greetings";
    }
    @GetMapping("/test")
    public String test() {
        throw new RuntimeException("Boom");
    }
}
