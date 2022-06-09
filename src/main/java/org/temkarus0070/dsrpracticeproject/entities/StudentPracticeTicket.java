package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
@Getter
@Setter
public class StudentPracticeTicket {
    @EmbeddedId
    private StudentPracticeTicketId id;
    @ManyToOne
    @MapsId(value = "mentorId")
    private Mentor mentor;
    @ManyToOne
    @MapsId(value = "studentId")
    private Student student;
    private String programmingLanguage;
    private LocalDate beginOfPractice;
    private LocalDate endOfPractice;
    private String taskName;
    @OneToMany
    private Set<WeeklyStudyReview> weeklyMentorReviews;
    @OneToOne
    private FinalStudyReview finalMentorReview;
    private boolean isRecommendToHire;
    @Enumerated(value = EnumType.STRING)
    private Mark mark;

    @Embeddable
    public static class StudentPracticeTicketId implements Serializable {
        private long mentorId;
        private long studentId;
    }
}
