package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.StudentView;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    StudentView getStudentById(long id);

    List<StudentView> getAllBy();
}
