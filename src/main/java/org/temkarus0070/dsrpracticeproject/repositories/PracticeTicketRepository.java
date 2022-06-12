package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsProjection;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketProjection;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsProjection;

import java.util.List;

@Repository
public interface PracticeTicketRepository extends JpaRepository<PracticeTicket, PracticeTicket.PracticeTicketId> {
    @EntityGraph("practiceTickerGraph")
    PracticeTicketProjection findPracticeTicketById(PracticeTicket.PracticeTicketId id);

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketProjection> findAllPracticeTicketBy();

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketProjection> findAllByOrderByRecommendToHireAscFinalMarkAsc();

    @Query(value = "SELECT t.mentor.id as mentorId,t.mentor.fullName as fullName,count(t.id.studentId) as studentsCount,SUM(CASE when t.recommendToHire is true then  1 else 0 end)as successStudentsCount" +
            "  from PracticeTicket t  group by t.mentor.id,t.mentor.fullName")
    List<MentorStudentsStatsProjection> findStatsByMentors();

    @Query(value = "SELECT pt.id.programmingLanguage as language,count(pt.student) as count from PracticeTicket pt group by pt.id.programmingLanguage")
    List<ProgrammingLanguageStatsProjection> findStatsByProgrammingLanguages();

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketProjection> findAllById_MentorId(long mentorId);

}
