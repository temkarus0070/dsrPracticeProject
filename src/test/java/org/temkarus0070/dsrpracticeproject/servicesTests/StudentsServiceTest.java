package org.temkarus0070.dsrpracticeproject.servicesTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.temkarus0070.dsrpracticeproject.services.StudentService;

@DataJpaTest
public class StudentsServiceTest {
    @Autowired
    private StudentService studentsService;

    @Test
    public void testCreate() {

    }
}
