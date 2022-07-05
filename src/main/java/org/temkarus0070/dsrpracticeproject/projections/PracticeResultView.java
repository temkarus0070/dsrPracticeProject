package org.temkarus0070.dsrpracticeproject.projections;

import org.temkarus0070.dsrpracticeproject.entities.Mark;

public interface PracticeResultView {
    StudentView getStudent();

    boolean isRecommendToHire();

    Mark getFinalMark();

    ProgrammingLanguagesView getProgrammingLanguage();
}
