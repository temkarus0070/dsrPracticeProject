package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;
import org.temkarus0070.dsrpracticeproject.repositories.PracticeTicketRepository;
import org.temkarus0070.dsrpracticeproject.repositories.ProgrammingLanguagesRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatsService {
    @Autowired
    private ProgrammingLanguagesRepository programmingLanguagesRepository;
    @Autowired
    private PracticeTicketRepository practiceTicketRepository;

    public List<PracticeResultView> getRatingOfStudents(LocalDate practiceBegin, LocalDate practiceEnd) {
        return practiceTicketRepository.findAllById_BeginOfPracticeIsGreaterThanEqualAndId_EndOfPracticeIsLessThanEqualOrderByRecommendToHireDescFinalMarkDesc(practiceBegin, practiceEnd);
    }

    public List<MentorStudentsStatsView> getStatsByMentors(LocalDate practiceBegin, LocalDate practiceEnd) {
        return practiceTicketRepository.findStatsByMentors(practiceBegin, practiceEnd);
    }

    public List<ProgrammingLanguageStatsView> getStatsByProgrammingLanguage(LocalDate practiceBegin, LocalDate practiceEnd) {
        return programmingLanguagesRepository.findStatsByProgrammingLanguages(practiceBegin, practiceEnd);
    }
}
