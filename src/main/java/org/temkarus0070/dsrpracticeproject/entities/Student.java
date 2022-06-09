package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student extends User{

private int studyCourse;

private String studyGroup;

private int testResult;

@OneToMany
private Set<StudentPracticeTicket> studentPracticeTickets;
}
