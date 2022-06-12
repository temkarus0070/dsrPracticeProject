package org.temkarus0070.dsrpracticeproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NamedEntityGraph(name = "practiceTickerGraph", includeAllAttributes = true)
public class PracticeTicket {
    @EmbeddedId
    private PracticeTicketId id;
    @ManyToOne(optional = false)
    @MapsId(value = "mentorId")
    private Mentor mentor;
    @ManyToOne(optional = false)
    @MapsId(value = "studentId")
    private Student student;

    private String taskName;
    @OneToMany(mappedBy = "practiceTicket")
    private Set<WeeklyStudyReview> weeklyMentorReviews;
    @OneToOne
    private FinalStudyReview finalMentorReview;
    private boolean recommendToHire;
    @Enumerated(value = EnumType.ORDINAL)
    private Mark finalMark;

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


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class PracticeTicketId implements Serializable {
        private long mentorId;
        private long studentId;
        private String programmingLanguage;
        private LocalDate beginOfPractice;
        private LocalDate endOfPractice;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PracticeTicketId that = (PracticeTicketId) o;
            return mentorId == that.mentorId && studentId == that.studentId && programmingLanguage.equals(that.programmingLanguage) && beginOfPractice.equals(that.beginOfPractice) && endOfPractice.equals(that.endOfPractice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mentorId, studentId, programmingLanguage, beginOfPractice, endOfPractice);
        }
    }
}
