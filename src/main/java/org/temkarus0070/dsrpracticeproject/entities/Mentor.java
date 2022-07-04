package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.temkarus0070.dsrpracticeproject.security.entities.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Mentor extends Person {
    @NotNull
    private String jobName;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.REMOVE)
    private Set<PracticeTicket> practiceTickets;

    @OneToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(getId(), mentor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
