package com.batal.demo.springandreact.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LoginResponse {

    private String userName;
    private String token;

    public LoginResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }
}


