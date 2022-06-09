package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.StudentView;
import org.temkarus0070.dsrpracticeproject.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public StudentView getStudent(@RequestParam long id) {
        return studentService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.add(student);
    }

    @PatchMapping
    public void update(@RequestBody Student student) {
        studentService.edit(student);
    }


}
