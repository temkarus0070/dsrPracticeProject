package org.temkarus0070.dsrpracticeproject.projections;

public interface MentorView extends PersonView {
    public String getJobName();

    public UserView getUser();

    public interface UserView {
        String getUsername();
    }
}
