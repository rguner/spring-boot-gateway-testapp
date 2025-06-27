package com.example.springbootgatewaytestapp.controller;


import com.example.springbootgatewaytestapp.model.Hello;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping("/response-header")
    public String testResponseHeader() {

        return "App is working, path /local-test-response-header";
    }

    @GetMapping("/rate-limit/get/test")
    public String testRateLimit() {

        log.info("Rate-Limit is working, path /rate-limit/get/test");
        return "App is working, path /rate-limit/get/test";
    }

    @GetMapping("/cache-test/test")
    public String testCache() {

        log.info("Cache is working, path /cache-test/test");
        return "App is working, path /cache/test";
    }

}
