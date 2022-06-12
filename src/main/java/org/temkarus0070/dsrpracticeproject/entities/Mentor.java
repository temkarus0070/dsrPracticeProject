package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Mentor extends Person {
    private String jobName;
    @OneToMany
    private Set<PracticeTicket> practiceTickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(getId(), mentor.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
