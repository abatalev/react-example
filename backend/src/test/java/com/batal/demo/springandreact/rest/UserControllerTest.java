package com.batal.demo.springandreact.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.batal.demo.springandreact.dto.UserDTO;
import com.batal.demo.springandreact.services.UserService;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserControllerTest {

    private DriverManagerDataSource dataSource;

    @BeforeEach
    public void setup(){
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:./target/reactdemo;create=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Flyway flyway = Flyway.configure()
            .dataSource(dataSource)
            .locations("db/migration", "db/testdata")
            .load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void checkUsers(){        
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UserDTO> users = new UserController(new UserService(jdbcTemplate)).getUsers();
        assertEquals(1, users.size());
    }
}