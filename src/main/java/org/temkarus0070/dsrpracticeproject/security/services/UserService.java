package org.temkarus0070.dsrpracticeproject.security.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.projections.UserProjection;
import org.temkarus0070.dsrpracticeproject.security.repositories.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsManager {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDetails user) {
        User user1 = new User(user);
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user1);
    }

    @Override
    public void updateUser(UserDetails user) {
        User user1 = userRepository.findById(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("не существует пользователя с таким именем"));
        user1.setRoles(user.getAuthorities().stream().map(e -> e.getAuthority()).collect(Collectors.toList()));
        user1.setActive(user.isEnabled());
        userRepository.save(user1);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findById(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("не существует пользователя с таким именем"));
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return user.getRoles().stream().map(e -> (GrantedAuthority) () -> e).collect(Collectors.toList());
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return user.isActive();
            }

            @Override
            public boolean isAccountNonLocked() {
                return user.isActive();
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return user.isActive();
            }

            @Override
            public boolean isEnabled() {
                return user.isActive();
            }
        };
    }

    public UserProjection get(String login) {
        return userRepository.findUserByUsername(login).orElseThrow(() -> new UsernameNotFoundException("не найдено пользователя с таким именем"));
    }
}
