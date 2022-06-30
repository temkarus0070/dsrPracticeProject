package org.temkarus0070.dsrpracticeproject.entities;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"task_name", "task_text"})})
public class PracticeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text")
    private String taskText;
    @OneToOne()
    private PracticeTicket practiceTicket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public PracticeTicket getPracticeTicket() {
        return practiceTicket;
    }

    public void setPracticeTicket(PracticeTicket practiceTicket) {
        this.practiceTicket = practiceTicket;
    }
}
