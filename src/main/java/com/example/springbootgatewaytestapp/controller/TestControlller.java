package com.example.springbootgatewaytestapp.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequiredArgsConstructor
public class TestControlller {


    private final HttpServletRequest httpRequest;

    @GetMapping("/local-test")
    public String testGateway() {
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        StringBuilder headers = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("Header: " + headerName + " = " + httpRequest.getHeader(headerName));
            headers.append(headerName).append(": ").append(httpRequest.getHeader(headerName)).append("\n");
        }
        Enumeration<String> parameterNames = httpRequest.getParameterNames();
        StringBuilder parameters = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = httpRequest.getParameter(paramName);
            System.out.println("Parameter: " + paramName + " = " + paramValue);
            parameters.append(paramName).append(": ").append(paramValue).append("\n");
        }

        return "Gateway is working, path /local-test \n Http Headers: " + headers
                + "\n Http Parameters: " + parameters;
    }


    @GetMapping("/")
    public String testRoot() {
        return "Gateway is working,  path /";
    }

    @GetMapping("/local-test/gw-test")
    public String testGateway2() {
        return "Gateway2 is working, path /local-test/gw-test";
    }
}
