package com.batal.demo.springandreact.rest;

import com.batal.demo.springandreact.dto.LoginRequest;
import com.batal.demo.springandreact.dto.LoginResponse;
import com.batal.demo.springandreact.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/api/ping")
    public String ping(Authentication authentication) {
        return "pong " + (authentication != null ? authentication.getName() : "");
    }

    @PostMapping(value = "/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest login) {
        return ResponseEntity.ok(
                new LoginResponse(
                        login.getUserName(),
                        loginService.generateToken(login.getUserName())));
    }
}
