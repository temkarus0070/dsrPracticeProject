package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.dsrpracticeproject.PracticeTicketStats;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;

import java.util.List;

@RestController
@RequestMapping("/practiceTicket/stats")
public class PracticeTicketStatsController {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @GetMapping("/byMentors")
    public List<MentorStudentsStatsView>  getStatsByMentors() {
        return practiceTicketService.getStatsByMentors();
    }

    @GetMapping("/programmingLanguages")
    public List<ProgrammingLanguageStatsView> getStatsByProgrammingLanguages(){
        return practiceTicketService.getStatsByProgrammingLanguage();
    }

    @GetMapping("/studentsRating")
    public List<PracticeResultView> getRating() {
        return practiceTicketService.getRatingOfStudents();
    }
}
