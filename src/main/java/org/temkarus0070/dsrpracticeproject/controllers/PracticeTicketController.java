package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.dsrpracticeproject.PracticeTicketStats;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketProjection;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/practiceTicket")
public class PracticeTicketController {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @GetMapping
    public PracticeTicketProjection get(@RequestParam long mentorId, @RequestParam long studentId, @RequestParam String programmingLanguage, @RequestParam LocalDate beginOfPractice,
                                        @RequestParam LocalDate endOfPractice) {
        PracticeTicket.PracticeTicketId practiceTicketId = new PracticeTicket.PracticeTicketId(mentorId, studentId, programmingLanguage, beginOfPractice, endOfPractice);
        return practiceTicketService.get(practiceTicketId);
    }

    @GetMapping("/all")
    public List<PracticeTicketProjection> list() {
        return practiceTicketService.getAll();
    }

    @GetMapping("/assignedToMentor")
    public List<PracticeTicketProjection> practiceTicketsOfMentor(long mentorId) {
        return practiceTicketService.getAll();
    }

    @GetMapping("/practiceStats")
    public PracticeTicketStats getStats() {
        return practiceTicketService.getStatsByPractice();
    }

}
