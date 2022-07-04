package org.temkarus0070.dsrpracticeproject.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.StudentView;
import org.temkarus0070.dsrpracticeproject.services.StudentService;

import java.util.List;
import java.util.stream.Stream;

@Import(StudentService.class)
@DataJpaTest
@TestPropertySource(
        properties = {
                "spring.sql.init.mode=never",
                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
        }
)
public class StudentsServiceTest {
    @Autowired
    private StudentService studentsService;

    @Test
    public void testCreate() {
        Student student = new Student();
        student.setId(Long.MAX_VALUE);
        student.setFullName("vasya 1234");
        studentsService.add(student);
        Assertions.assertEquals(1, studentsService.getAll()
                .stream().filter(e -> e.getFullName().equals(student.getFullName())).count());
    }


    @Test
    public void testEdit() {
        Student student = new Student();
        student.setId(Long.MAX_VALUE);
        student.setFullName("vasya 1234");
        studentsService.add(student);
        List<StudentView> all = studentsService.getAll();
        Stream<StudentView> studentViewStream = all.stream().filter(e -> e.getFullName().equals(student.getFullName()));
        Assertions.assertEquals(1, studentViewStream.count());

        student.setStudyCourse(1);
        studentsService.edit(student, all.get(0).getId());
        StudentView studentView = studentsService.get(all.get(0).getId());
        Assertions.assertEquals(student.getStudyCourse(), studentView.getStudyCourse());
    }

    @Test
    public void testDelete() {
        Student student = new Student();
        student.setId(Long.MAX_VALUE);
        student.setFullName("vasya 1234");
        studentsService.add(student);
        List<StudentView> all = studentsService.getAll();
        Stream<StudentView> studentViewStream = all
                .stream().filter(e -> e.getFullName().equals(student.getFullName()));
        Assertions.assertEquals(1, studentViewStream.count());
        studentsService.delete(all.get(0).getId());
        Assertions.assertEquals(0, studentsService.getAll().size());
    }

}
