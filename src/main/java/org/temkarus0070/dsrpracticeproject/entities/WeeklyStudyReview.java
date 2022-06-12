package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
public class WeeklyStudyReview extends StudyReview {
    @ManyToOne
    private PracticeTicket practiceTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WeeklyStudyReview that = (WeeklyStudyReview) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
