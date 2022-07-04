package org.temkarus0070.dsrpracticeproject.security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.security.entities.JWTUser;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.repositories.JwtRepository;

import java.util.Optional;

@Service
public class JwtService {
    private JwtRepository jwtRepository;
    private String secret;
    @Autowired
    private UserService userService;
    private com.auth0.jwt.JWTVerifier jwtVerifier;
    private Algorithm algorithm;

    public JwtService(JwtRepository jwtRepository,
                      @Value("application.very-secret-key") String secret) {
        this.jwtRepository = jwtRepository;
        this.secret = secret;
        this.algorithm = Algorithm.HMAC256(secret);
        this.jwtVerifier = JWT.require(algorithm)
                .withIssuer("dsr practice")
                .build();
    }

    public JWTUser generate(UserDetails userDetails) {
        String token = JWT.create()
                .withIssuer("dsr practice")
                .withSubject(userDetails.getUsername())
                .sign(algorithm);
        JWTUser jwtUser = new JWTUser();
        jwtUser.setUser(new User(userDetails));
        jwtUser.setId(new JWTUser.JwtId(userDetails.getUsername(), token));
        return jwtUser;
    }

    public String createNew(UserDetails userDetails) {
        JWTUser jwtToken = generate(userDetails);
        jwtRepository.save(jwtToken);
        return jwtToken.getId().getJwt();
    }

    public boolean isValidToken(String token) {
        jwtVerifier.verify(token);
        String jwtUserName = JWT.decode(token).getSubject();
        Optional<JWTUser> jwtUser = jwtRepository.findById(new JWTUser.JwtId(jwtUserName, token));
        return jwtUser.isPresent();
    }

    public UserDetails getUser(String token) {
        jwtVerifier.verify(token);
        String jwtUserName = JWT.decode(token).getSubject();
        return userService.loadUserByUsername(jwtUserName);
    }
}
