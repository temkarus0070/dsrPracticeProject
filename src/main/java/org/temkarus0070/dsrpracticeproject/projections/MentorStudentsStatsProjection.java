package org.temkarus0070.dsrpracticeproject.projections;

public interface MentorStudentsStatsProjection {
    long getStudentsCount();

    long getMentorId();

    String getFullName();

    long getSuccessStudentsCount();
}
