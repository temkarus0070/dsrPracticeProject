package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class PracticeTask {
    @EmbeddedId
    private PracticeTaskId id;
    @OneToOne(mappedBy = "practiceTask")
    private PracticeTicket practiceTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PracticeTask)) return false;
        PracticeTask that = (PracticeTask) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Embeddable
    public static class PracticeTaskId implements Serializable {
        private static final long serialVersionUID = 4072631243273740450L;
        private String taskName;
        private String taskText;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PracticeTaskId)) return false;
            PracticeTaskId that = (PracticeTaskId) o;
            return taskName.equals(that.taskName) && taskText.equals(that.taskText);
        }

        @Override
        public int hashCode() {
            return Objects.hash(taskName, taskText);
        }
    }
}
