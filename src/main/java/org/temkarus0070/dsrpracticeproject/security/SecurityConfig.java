package org.temkarus0070.dsrpracticeproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.temkarus0070.dsrpracticeproject.security.filters.JwtFilter;
import org.temkarus0070.dsrpracticeproject.security.filters.UsernamePasswordFilter;
import org.temkarus0070.dsrpracticeproject.security.managers.JwtAuthProvider;
import org.temkarus0070.dsrpracticeproject.security.managers.UsernameAuthProvider;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${application.frontend-address}")
    private String frontendUrl;
    @Autowired
    private UsernamePasswordFilter usernamePasswordFilter;

    @Autowired
    private UsernameAuthProvider usernameAuthProvider;

    @Autowired
    private JwtAuthProvider jwtAuthProvider;

    @Autowired
    private JwtFilter jwtFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().and()
                .authorizeHttpRequests().mvcMatchers("/register")
                .permitAll().and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and().csrf().disable()
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfiguration()))
                .httpBasic().disable()
                .formLogin()
                .disable()
                .addFilter(jwtFilter)
                .addFilter(usernamePasswordFilter)
                .authenticationProvider(jwtAuthProvider)
                .authenticationProvider(usernameAuthProvider)
                .anonymous();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Collections.singletonList(frontendUrl));
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setExposedHeaders(Arrays.asList("refreshToken", "token", "Authorization"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
