package com.example.securitytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    // For using url path /login instead of /login.html
    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
