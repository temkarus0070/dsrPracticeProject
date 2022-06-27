package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"task_name", "task_text"})})
public class PracticeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text")
    private String taskText;
    @OneToOne(mappedBy = "practiceTask")
    private PracticeTicket practiceTicket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PracticeTask)) return false;
        PracticeTask that = (PracticeTask) o;
        return id == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
