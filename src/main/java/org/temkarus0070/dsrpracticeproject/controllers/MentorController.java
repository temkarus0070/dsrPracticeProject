package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.projections.MentorView;
import org.temkarus0070.dsrpracticeproject.services.MentorService;

import java.util.List;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @GetMapping("/{id}")
    public MentorView get(@PathVariable long id) {
        return mentorService.get(id);
    }

    @GetMapping
    public List<MentorView> getList() {
        return mentorService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Mentor mentor) {
        mentorService.add(mentor);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Mentor mentor) {
        mentorService.update(mentor, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        mentorService.delete(id);
    }
}
