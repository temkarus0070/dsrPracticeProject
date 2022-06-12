package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.dsrpracticeproject.PracticeTicketStats;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/practiceTicket")
public class PracticeTicketController {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @GetMapping
    public PracticeTicketView get(@RequestParam long mentorId, @RequestParam long studentId, @RequestParam String programmingLanguage, @RequestParam LocalDate beginOfPractice,
                                  @RequestParam LocalDate endOfPractice) {
        PracticeTicket.PracticeTicketId practiceTicketId = new PracticeTicket.PracticeTicketId(mentorId, studentId, programmingLanguage, beginOfPractice, endOfPractice);
        return practiceTicketService.get(practiceTicketId);
    }

    @GetMapping("/all")
    public List<PracticeTicketView> list() {
        return practiceTicketService.getAll();
    }

    @GetMapping("/assignedToMentor")
    public List<PracticeTicketView> practiceTicketsOfMentor(@RequestParam long mentorId) {
        return practiceTicketService.getAllTicketsAssignedToMentor(mentorId);
    }

    @GetMapping("/practiceStats")
    public PracticeTicketStats getStats() {
        return practiceTicketService.getStatsByPractice();
    }

    @GetMapping("/studentsRating")
    public List<PracticeResultView> getRating() {
        return practiceTicketService.getRatingOfStudents();
    }

}
