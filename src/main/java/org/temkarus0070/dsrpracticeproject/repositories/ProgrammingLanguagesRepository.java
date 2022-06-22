package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.ProgrammingLanguage;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgrammingLanguagesRepository extends JpaRepository<ProgrammingLanguage, Long> {

    @Query(value = "SELECT pl.name as language,count(pt) as count from ProgrammingLanguage pl  left join  pl.practiceTickets pt on pt.id.beginOfPractice >= :beginPractice and pt.id.endOfPractice<= :endPractice group by pl.name")
    List<ProgrammingLanguageStatsView> findStatsByProgrammingLanguages(LocalDate beginPractice, LocalDate endPractice);
}
