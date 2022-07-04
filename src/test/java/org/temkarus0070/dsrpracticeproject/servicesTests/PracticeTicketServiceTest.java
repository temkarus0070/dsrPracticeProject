package org.temkarus0070.dsrpracticeproject.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.entities.ProgrammingLanguage;
import org.temkarus0070.dsrpracticeproject.entities.Student;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.services.MentorService;
import org.temkarus0070.dsrpracticeproject.services.PracticeTicketService;
import org.temkarus0070.dsrpracticeproject.services.ProgrammingLanguagesService;
import org.temkarus0070.dsrpracticeproject.services.StudentService;

import java.time.LocalDate;

@Import({PracticeTicketService.class, MentorService.class, StudentService.class, ProgrammingLanguagesService.class})
@DataJpaTest
@TestPropertySource(
        properties = {
                "spring.sql.init.mode=never",
                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
        }
)
public class PracticeTicketServiceTest {
    @Autowired
    private PracticeTicketService practiceTicketService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProgrammingLanguagesService programmingLanguagesService;

    @Test
    public void testAdd() {
        Mentor mentor = new Mentor();
        mentor.setFullName("Alla");
        mentor.setJobName("java");
        Student student = new Student();
        student.setFullName("vasya");
        studentService.add(student);
        mentorService.add(mentor);
        student.setId(studentService.getAll().get(0).getId());
        mentor.setId(mentorService.getAll().get(0).getId());
        PracticeTicket practiceTicket = new PracticeTicket();
        practiceTicket.setId(new PracticeTicket.PracticeTicketId());
        practiceTicket.setStudent(student);
        practiceTicket.setMentor(mentor);

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName("java");
        programmingLanguagesService.create(programmingLanguage);
        programmingLanguage.setId(programmingLanguagesService.getSimpleList().get(0).getId());
        practiceTicket.setProgrammingLanguage(programmingLanguage);
        practiceTicket.getId().setBeginOfPractice(LocalDate.ofYearDay(2022, 1));
        practiceTicket.getId().setEndOfPractice(LocalDate.ofYearDay(2023, 1));

        practiceTicketService.add(practiceTicket);

        practiceTicket.getId().setMentorId(mentor.getId());
        practiceTicket.getId().setStudentId(student.getId());
        practiceTicket.getId().setProgrammingLanguageId(programmingLanguage.getId());
        PracticeTicketView practiceTicketView = practiceTicketService.get(practiceTicket.getId());
        Assertions.assertTrue(practiceTicketView.getProgrammingLanguage().getName().equals(programmingLanguage.getName()));
        Assertions.assertEquals(practiceTicket.getId().getBeginOfPractice(), practiceTicketView.getId().getBeginOfPractice());
        Assertions.assertEquals(practiceTicket.getId().getEndOfPractice(), practiceTicketView.getId().getEndOfPractice());
        Assertions.assertEquals(practiceTicket.getStudent().getId(), practiceTicketView.getStudent().getId());
        Assertions.assertEquals(practiceTicket.getMentor().getId(), practiceTicketView.getMentor().getId());
    }

}
