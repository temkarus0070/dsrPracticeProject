package org.temkarus0070.dsrpracticeproject.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.projections.UserProjection;
import org.temkarus0070.dsrpracticeproject.security.services.UserService;
import org.temkarus0070.dsrpracticeproject.services.MentorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private MentorService mentorService;

    @GetMapping("/current-user")
    public UserProjection checkAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.get(authentication.getName());
    }

    @PostMapping("/register")
    public void register(@RequestBody Mentor mentor) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add((GrantedAuthority) () -> {
            return "mentor";
        });
        User user = mentor.getUser();
        userService.createUser(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), false, false, false, false, authorityList));
        mentorService.add(mentor);
    }

    @PostMapping("/mentors/{id}/approve-register")
    public void approveMentorRegister(@PathVariable long id) {
        Mentor mentor1 = mentorService.getMentor(id);
        List<GrantedAuthority> grantedAuthorities = mentor1.getUser().getRoles().stream().map(e -> (GrantedAuthority) () -> e).collect(Collectors.toList());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(mentor1.getUser().getUsername(), mentor1.getUser().getPassword(), true, true, true, true, grantedAuthorities);
        userService.updateUser(userDetails);

    }


}
