package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home() {
        System.out.println("Home Page handler");
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        System.out.println("About Page handler");
        return "about";
    }

}
