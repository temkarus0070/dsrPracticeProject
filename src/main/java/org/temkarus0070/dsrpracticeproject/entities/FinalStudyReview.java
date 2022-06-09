package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class FinalStudyReview extends StudyReview{
    @OneToOne
private StudentPracticeTicket studentPracticeTicket;
}
