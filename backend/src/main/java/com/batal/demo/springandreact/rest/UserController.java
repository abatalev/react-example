package com.batal.demo.springandreact.rest;

import com.batal.demo.springandreact.dto.UserDTO;
import com.batal.demo.springandreact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }
}