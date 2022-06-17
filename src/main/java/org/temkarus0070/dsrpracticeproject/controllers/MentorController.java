package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.projections.MentorView;
import org.temkarus0070.dsrpracticeproject.services.MentorService;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @GetMapping
    public MentorView get(@RequestParam long mentorId) {
        return mentorService.get(mentorId);
    }

    @GetMapping
    public List<MentorView> getList() {
        return mentorService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Mentor mentor){
        mentorService.add(mentor);
    }

    @PatchMapping
    public void update(@RequestBody Mentor mentor) {
        mentorService.update(mentor);
    }

    @DeleteMapping
    public void delete(@RequestParam long mentorId) {
        mentorService.delete(mentorId);
    }
}
