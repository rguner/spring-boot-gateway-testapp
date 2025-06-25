package com.example.springbootgatewaytestapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FallbackController {

    @GetMapping("/error-method")
    public String errorMethod() {
        throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Gateway Timeout");
    }

    @GetMapping("/status/502")
    public String status502() {
        throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Bad Gateway");
    }

    @GetMapping("/status/504")
    public String status504() {
        log.info("Status 504");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }
        throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Gateway Timeout");
    }

}
