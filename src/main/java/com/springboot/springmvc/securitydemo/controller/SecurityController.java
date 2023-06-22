package com.springboot.springmvc.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/home")
    public String helloWorld(){
        return "homepage";
    }


    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }


    @GetMapping("/moderators")
    public String moderators(){

        return "moderators";
    }

    @GetMapping("/owners")
    public String owners(){
        return "owners";
    }
}
