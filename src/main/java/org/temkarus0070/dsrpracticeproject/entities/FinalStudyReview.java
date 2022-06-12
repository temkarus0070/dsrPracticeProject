package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
public class FinalStudyReview extends StudyReview {
    @OneToOne
    private PracticeTicket practiceTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FinalStudyReview that = (FinalStudyReview) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
