package com.batal.demo.springandreact.security;

import com.batal.demo.springandreact.services.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JwtTokenCalculatorTest {

    @Test
    public void checkAuthNonBearer() {
        String token = "ahgsdj";
        JwtTokenCalculator calculator = new JwtTokenCalculator("secret");
        Authentication authentication = calculator.calcAuth("Basic " + token, "/");
        assertNull(authentication);
    }

    @Test
    public void checkAuthWithBadToken() {
        String token = "ahgsdj";
        JwtTokenCalculator calculator = new JwtTokenCalculator("secret");
        Authentication authentication = calculator.calcAuth("Bearer " + token, "/");
        assertNull(authentication);
    }

    @Test
    public void checkAuthWithExpiredToken() {
        LoginService service = new LoginService(-1000, "secret");
        String token = service.generateToken("andrey");
        JwtTokenCalculator calculator = new JwtTokenCalculator("secret");
        Authentication authentication = calculator.calcAuth("Bearer " + token, "/");
        assertNull(authentication);
    }

    @Test
    public void checkAuthWithGoodToken() {
        LoginService service = new LoginService(60000, "secret");
        String token = service.generateToken("andrey");
        JwtTokenCalculator calculator = new JwtTokenCalculator("secret");
        Authentication authentication = calculator.calcAuth("Bearer " + token, "/");
        assertNotNull(authentication);
    }
}
