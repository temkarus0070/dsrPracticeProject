package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Mentor extends User {
    private String jobName;
    @OneToMany
    private Set<StudentPracticeTicket> studentPracticeTickets;
}
