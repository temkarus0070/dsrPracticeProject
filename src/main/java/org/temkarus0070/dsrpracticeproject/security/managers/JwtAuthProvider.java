package org.temkarus0070.dsrpracticeproject.security.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.temkarus0070.dsrpracticeproject.security.JwtAuth;
import org.temkarus0070.dsrpracticeproject.security.services.JwtService;

@Component
public class JwtAuthProvider implements AuthenticationProvider {
    @Autowired
    private JwtService jwtService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        boolean validToken = jwtService.isValidToken(authentication.getCredentials().toString());
        if (validToken) {
            UserDetails user = jwtService.getUser(authentication.getCredentials().toString());
            return new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        } else throw new BadCredentialsException("неверный токен");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuth.class.isAssignableFrom(authentication);
    }
}
