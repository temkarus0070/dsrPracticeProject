package org.temkarus0070.dsrpracticeproject.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;

public class JwtAuth extends UsernamePasswordAuthenticationToken {
    public JwtAuth(String token) {
        super("user", token, new ArrayList<>());
    }
}
