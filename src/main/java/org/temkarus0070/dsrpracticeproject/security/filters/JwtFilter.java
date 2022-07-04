package org.temkarus0070.dsrpracticeproject.security.filters;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.temkarus0070.dsrpracticeproject.security.JwtAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends UsernamePasswordAuthenticationFilter {
    public JwtFilter(@Lazy AuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String authentication = request.getHeader("Authorization");
        if (authentication != null && authentication.length() > 0) {
            JwtAuth jwtAuth = new JwtAuth(authentication);
            Authentication authenticate = getAuthenticationManager().authenticate(jwtAuth);
            return authenticate;
        } else throw new BadCredentialsException("не найдено токена в http request");
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String requestURI = request.getRequestURI();
        return !requestURI.contains("/login");
    }
}
