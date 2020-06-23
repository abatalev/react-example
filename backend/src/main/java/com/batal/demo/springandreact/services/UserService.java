package com.batal.demo.springandreact.services;

import com.batal.demo.springandreact.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserDTO> getUsers() {
        return jdbcTemplate.query("select user_id, user_label from users",
                (rs, rowNum) -> new UserDTO(
                        rs.getString(1),
                        rs.getString(2)));
    }
}
