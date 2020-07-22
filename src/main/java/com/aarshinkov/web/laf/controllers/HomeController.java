package com.aarshinkov.web.laf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // localhost:8080/
    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/atanas")
    public String testMethod() {
        return "index";
    }
}
