package org.temkarus0070.dsrpracticeproject.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;
import org.temkarus0070.dsrpracticeproject.services.StatsService;

import java.time.LocalDate;
import java.util.List;

@Import(StatsService.class)
@Sql("classpath:data.sql")
@DataJpaTest
@TestPropertySource(
        properties = {
                "spring.sql.init.mode=never",
                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
        }
)
public class StatsServiceTest {
    @Autowired
    private StatsService statsService;

    @Test
    public void testStatsByMentors() {
        List<MentorStudentsStatsView> statsByMentors = statsService.getStatsByMentors(LocalDate.ofYearDay(2021, 31), LocalDate.ofYearDay(2023, 12));
        statsByMentors.sort((e1, e2) -> {
            if (e1.getMentorId() > e2.getMentorId()) {
                return 1;
            } else if (e1.getMentorId() == e2.getMentorId()) {
                return 0;
            }
            return -1;
        });
        Assertions.assertEquals(statsByMentors.get(0).getStudentsCount(), 1);
        Assertions.assertEquals(statsByMentors.get(0).getSuccessStudentsCount(), 1);
        Assertions.assertEquals(statsByMentors.get(1).getStudentsCount(), 3);
        Assertions.assertEquals(statsByMentors.get(1).getSuccessStudentsCount(), 1);

        Assertions.assertTrue(statsByMentors.size() == 2);

    }

    @Test
    public void testStatsByStudents() {
        List<PracticeResultView> practiceResults = statsService.getRatingOfStudents(LocalDate.ofYearDay(2021, 31), LocalDate.ofYearDay(2023, 12));
        Assertions.assertEquals(practiceResults.size(), 4);
        Assertions.assertTrue(practiceResults.get(0).isRecommendToHire());
        Assertions.assertTrue(practiceResults.get(1).isRecommendToHire());
        Assertions.assertEquals(practiceResults.stream().filter(e -> !e.isRecommendToHire()).count(), 2);

        boolean isSorted = true;
        for (int i = 1; i < practiceResults.stream().filter(e -> e.isRecommendToHire()).count(); i++) {
            if (!(practiceResults.get(i - 1).getFinalMark().ordinal() > practiceResults.get(i).getFinalMark().ordinal())) {
                isSorted = false;
            }
        }
        Assertions.assertTrue(isSorted);

        isSorted = true;
        for (int i = 3; i < practiceResults.stream().filter(e -> !e.isRecommendToHire()).count(); i++) {
            if (!(practiceResults.get(i - 1).getFinalMark().ordinal() > practiceResults.get(i).getFinalMark().ordinal())) {
                isSorted = false;
            }
        }
        Assertions.assertTrue(isSorted);
    }

    @Test
    public void testStatsByStudentsAndWithPeriod() {
        List<PracticeResultView> practiceResults = statsService.getRatingOfStudents(LocalDate.of(2022, 05, 22), LocalDate.of(2022, 06, 11));
        Assertions.assertEquals(practiceResults.size(), 3);
        Assertions.assertEquals(practiceResults.stream().filter(e -> !e.isRecommendToHire()).count(), 2);
    }

    @Test
    public void testProgLanguagesStats() {
        List<ProgrammingLanguageStatsView> statsByProgrammingLanguage = statsService.getStatsByProgrammingLanguage(LocalDate.ofYearDay(2021, 31), LocalDate.ofYearDay(2023, 12));
        Assertions.assertEquals(statsByProgrammingLanguage.size(), 3);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("html")).findFirst().get().getCount(), 2);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("js")).findFirst().get().getCount(), 1);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("java")).findFirst().get().getCount(), 1);
    }

    @Test
    public void testProgLanguagesStatsWithPeriod() {
        List<ProgrammingLanguageStatsView> statsByProgrammingLanguage = statsService.getStatsByProgrammingLanguage(LocalDate.of(2022, 05, 22), LocalDate.of(2022, 06, 11));
        Assertions.assertEquals(statsByProgrammingLanguage.size(), 3);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("html")).findFirst().get().getCount(), 2);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("js")).findFirst().get().getCount(), 1);
        Assertions.assertEquals(statsByProgrammingLanguage.stream().filter(e -> e.getLanguage().equalsIgnoreCase("java")).findFirst().get().getCount(), 0);
    }


}
