package com.batal.demo.springandreact.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/api/hello")
    public String hello() {
        log.info("HelloController.hello");
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}
