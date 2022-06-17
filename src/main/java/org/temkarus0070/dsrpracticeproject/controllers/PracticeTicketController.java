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

    @GetMapping
    public List<PracticeTicketView> list() {
        return practiceTicketService.getAll();
    }

    @PostMapping
    public void create(@RequestBody PracticeTicket practiceTicket){
        practiceTicketService.add(practiceTicket);
    }

    @GetMapping("/assignedToMentor")
    public List<PracticeTicketView> practiceTicketsOfMentor(@RequestParam long mentorId) {
        return practiceTicketService.getAllTicketsAssignedToMentor(mentorId);
    }


}
