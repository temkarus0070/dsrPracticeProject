package org.temkarus0070.dsrpracticeproject.security.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class JWTUser {
    @ManyToOne
    @MapsId("username")
    private User user;

    @EmbeddedId
    private JwtId id;

    @Getter
    @Setter
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JwtId implements Serializable {
        private String username;
        @Lob
        private String jwt;
    }
}
