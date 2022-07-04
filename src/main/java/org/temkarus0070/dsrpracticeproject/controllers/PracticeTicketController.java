package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PracticeTicketController {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @GetMapping("/practice-tickets/practice-ticket")
    public PracticeTicketView get(@RequestParam long mentorId, @RequestParam long studentId, @RequestParam long programmingLanguageId, @RequestParam LocalDate beginOfPractice,
                                  @RequestParam LocalDate endOfPractice) {
        PracticeTicket.PracticeTicketId practiceTicketId = new PracticeTicket.PracticeTicketId(mentorId, studentId, programmingLanguageId, beginOfPractice, endOfPractice);
        return practiceTicketService.get(practiceTicketId);
    }

    @GetMapping("/practice-tickets")
    public List<PracticeTicketView> list() {
        List<PracticeTicketView> all = practiceTicketService.getAll();
        return all;
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/practice-tickets")
    public void create(@RequestBody PracticeTicket practiceTicket) {
        practiceTicketService.add(practiceTicket);
    }


    @GetMapping("/mentors/{id}/practice-tickets")
    public List<PracticeTicketView> practiceTicketsOfMentor(@PathVariable long id) {
        return practiceTicketService.getAllTicketsAssignedToMentor(id);
    }

    @GetMapping("/students/{id}/practice-tickets")
    public List<PracticeTicketView> practiceTicketsOfStudent(@PathVariable long id) {
        return practiceTicketService.getAllTicketsAssignedToStudent(id);
    }

    @PatchMapping("/practice-tickets")
    public void update(@RequestBody PracticeTicket practiceTicket) {
        practiceTicketService.update(practiceTicket);
    }


    @DeleteMapping("/practice-tickets")
    public void delete(@RequestParam long mentorId, @RequestParam long studentId, @RequestParam long programmingLanguageId, @RequestParam LocalDate beginOfPractice,
                       @RequestParam LocalDate endOfPractice) {
        practiceTicketService.delete(new PracticeTicket.PracticeTicketId(mentorId, studentId, programmingLanguageId, beginOfPractice, endOfPractice));
    }


}
