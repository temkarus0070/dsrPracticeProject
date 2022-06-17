package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.PracticeTicketStats;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PracticeTicketController {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @GetMapping("/practice-tickets")
    public PracticeTicketView get(@RequestParam long mentorId, @RequestParam long studentId, @RequestParam String programmingLanguage, @RequestParam LocalDate beginOfPractice,
                                  @RequestParam LocalDate endOfPractice) {
        PracticeTicket.PracticeTicketId practiceTicketId = new PracticeTicket.PracticeTicketId(mentorId, studentId, programmingLanguage, beginOfPractice, endOfPractice);
        return practiceTicketService.get(practiceTicketId);
    }

    @GetMapping("/practice-tickets")
    public List<PracticeTicketView> list() {
        return practiceTicketService.getAll();
    }

    @PostMapping("/practice-tickets")
    public void create(@RequestBody PracticeTicket practiceTicket){
        practiceTicketService.add(practiceTicket);
    }

    @GetMapping("/mentors/{id}/practice-tickets")
    public List<PracticeTicketView> practiceTicketsOfMentor(@PathVariable long id) {
        return practiceTicketService.getAllTicketsAssignedToMentor(id);
    }


}
