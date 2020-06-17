package com.batal.demo.springandreact.rest;

import com.batal.demo.springandreact.dto.LoginRequest;
import com.batal.demo.springandreact.dto.LoginResponse;
import com.batal.demo.springandreact.services.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginControllerTest {

    @Test
    public void checkLogin() {

        LoginRequest login = new LoginRequest();
        login.setUserName("andrey");

        LoginController controller = new LoginController(new LoginService(36000,"secret"));
        //controller.
        ResponseEntity responseEntity = controller.login(login);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("andrey", ((LoginResponse) responseEntity.getBody()).getUserName());
        assertEquals(132, ((LoginResponse) responseEntity.getBody()).getToken().length());
    }
}
