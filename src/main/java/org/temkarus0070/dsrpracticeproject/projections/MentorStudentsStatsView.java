package org.temkarus0070.dsrpracticeproject.projections;

public interface MentorStudentsStatsView {
    long getStudentsCount();

    long getMentorId();

    String getFullName();

    long getSuccessStudentsCount();
}
