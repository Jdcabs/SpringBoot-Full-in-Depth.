package com.dailycode.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //with this way of creating rest endpoint, its verbose
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Welcome to My Code.";
    }

    @GetMapping("/2")
    public String helloWorld2() {
        return "Welcome to My Code.";
    }
}
