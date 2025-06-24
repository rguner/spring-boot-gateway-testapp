package com.example.springbootgatewaytestapp.controller;

import com.example.springbootgatewaytestapp.model.Hello;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public String hello(@RequestBody Hello hello) {

        return hello.getTitle() + " " + hello.getMessage();
    }

}
