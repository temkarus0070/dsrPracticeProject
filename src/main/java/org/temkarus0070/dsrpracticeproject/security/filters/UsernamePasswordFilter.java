package org.temkarus0070.dsrpracticeproject.security.filters;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.temkarus0070.dsrpracticeproject.security.services.JwtService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class UsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public UsernamePasswordFilter(JwtService jwtService, @Lazy AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            }
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        Authentication authenticate = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String token = jwtService.createNew(new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return authenticate.getAuthorities();
            }

            @Override
            public String getPassword() {
                return "ENCRYPT";
            }

            @Override
            public String getUsername() {
                return authenticate.getName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        });
        response.setHeader("token", token);
        return authenticate;
    }


}
