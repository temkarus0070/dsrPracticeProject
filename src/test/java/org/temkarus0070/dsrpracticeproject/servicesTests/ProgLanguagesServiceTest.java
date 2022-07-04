package org.temkarus0070.dsrpracticeproject.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.temkarus0070.dsrpracticeproject.entities.ProgrammingLanguage;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguagesView;
import org.temkarus0070.dsrpracticeproject.services.ProgrammingLanguagesService;

@Import(ProgrammingLanguagesService.class)
@DataJpaTest
@TestPropertySource(
        properties = {
                "spring.sql.init.mode=never",
                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
        }
)
public class ProgLanguagesServiceTest {
    @Autowired
    private ProgrammingLanguagesService programmingLanguagesService;

    @Test
    public void createTest() {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName("php");
        programmingLanguagesService.create(programmingLanguage);

        ProgrammingLanguagesView php = programmingLanguagesService.get("php");
        Assertions.assertNotNull(php);
    }

    @Test
    public void getListTest() {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName("php");
        programmingLanguagesService.create(programmingLanguage);
        ProgrammingLanguage programmingLanguage1 = new ProgrammingLanguage();
        programmingLanguage1.setName("C#");
        programmingLanguagesService.create(programmingLanguage1);

        Assertions.assertEquals(2, programmingLanguagesService.getSimpleList().size());
    }

}
