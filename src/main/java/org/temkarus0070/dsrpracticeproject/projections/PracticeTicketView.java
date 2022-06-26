package org.temkarus0070.dsrpracticeproject.projections;

import org.temkarus0070.dsrpracticeproject.entities.Mark;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;

import java.util.Set;

public interface PracticeTicketView {
    PracticeTicket.PracticeTicketId getId();

    MentorView getMentor();

    StudentView getStudent();


    TaskProjection getPracticeTask();

    boolean isRecommendToHire();

    Mark getFinalMark();

    Set<StudyReviewProjection> getWeeklyMentorReviews();

    StudyReviewProjection getFinalMentorReview();

    ProgrammingLanguagesView getProgrammingLanguage();

    interface StudyReviewProjection {
        long getId();

        String getTextReview();
    }

    public interface TaskProjection {
        public String getTaskName();

        public String getTaskText();
    }
}
