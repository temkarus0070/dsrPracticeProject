package org.temkarus0070.dsrpracticeproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.temkarus0070.dsrpracticeproject.security.services.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Initializer {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        if (!userService.userExists("admin")) {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add((GrantedAuthority) () -> "admin");
            UserDetails userDetails = new User("admin", "1234", true, true, true, true, authorityList);
            userService.createUser(userDetails);
        }
    }
}
