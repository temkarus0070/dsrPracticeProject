package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.StudentView;
import org.temkarus0070.dsrpracticeproject.repositories.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void edit(Student student, long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student1 = optionalStudent.orElseThrow(EntityNotFoundException::new);
        student1.setContactData(student.getContactData());
        student1.setFullName(student.getFullName());
        student1.setStudyCourse(student.getStudyCourse());
        student1.setStudyGroup(student.getStudyGroup());
        student1.setTestResult(student.getTestResult());
        studentRepository.save(student1);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    public StudentView get(long id) {
        return studentRepository.getStudentById(id);
    }

    public List<StudentView> getAll() {
        return studentRepository.getAllBy();
    }
}
