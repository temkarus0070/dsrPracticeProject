package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.StudentView;
import org.temkarus0070.dsrpracticeproject.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentView getStudent(@PathVariable long id) {
        return studentService.get(id);
    }

    @GetMapping
    public List<StudentView> getList() {
        return studentService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentService.add(student);
    }

    @PatchMapping
    public void update(@RequestBody Student student) {
        studentService.edit(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }


}
