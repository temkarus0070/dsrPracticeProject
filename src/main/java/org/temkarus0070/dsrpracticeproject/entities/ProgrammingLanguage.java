package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<PracticeTicket> practiceTickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgrammingLanguage)) return false;
        ProgrammingLanguage that = (ProgrammingLanguage) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
