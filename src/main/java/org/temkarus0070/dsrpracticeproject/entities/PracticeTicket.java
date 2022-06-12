package org.temkarus0070.dsrpracticeproject.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class PracticeTicket {
    @EmbeddedId
    private PracticeTicketId id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PracticeTicket that = (PracticeTicket) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Embeddable
    @EqualsAndHashCode
    public static class PracticeTicketId implements Serializable {
        private long mentorId;
        private long studentId;
    }
}
