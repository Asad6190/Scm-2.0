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

    @GetMapping("/services")
    public String services() {
        System.out.println("Services Page handler");
        return "services";
    }

    @GetMapping("/about")
    public String about() {
        System.out.println("About Page handler");
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        System.out.println("Contact Page handler");
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login Page handler");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("Register Page handler");
        return "register";
    }
}
