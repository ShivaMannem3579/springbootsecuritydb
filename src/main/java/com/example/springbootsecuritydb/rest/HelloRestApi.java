package com.example.springbootsecuritydb.rest;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/")
public class HelloRestApi {


    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/hello")
    public String securedHello(){
        return "Secured Hello";
    }



    @GetMapping("/secured/alternate")
    public String securedAlternate(){
        return "Secured alternate";
    }
}
