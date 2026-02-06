package com.example.springbootgatewaytestapp.controller;

import com.example.springbootgatewaytestapp.model.Hello;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/v1/hello")
    public String hello(@RequestBody Hello hello) {

        System.out.println("Title: " + hello.getMessage() + ". Sleep for 10 seconds to simulate a long process.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return hello.getTitle() + " " + hello.getMessage();
    }

}
