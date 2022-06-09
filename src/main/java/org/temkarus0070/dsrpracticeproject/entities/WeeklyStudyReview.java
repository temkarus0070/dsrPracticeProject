package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class WeeklyStudyReview extends StudyReview{
    @ManyToOne
    private StudentPracticeTicket studentPracticeTicket;
}
