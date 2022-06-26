package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student extends Person {

    private int studyCourse;

    private String studyGroup;

    @Min(0)
    @Max(100)
    private int testResult;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private Set<PracticeTicket> practiceTickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
