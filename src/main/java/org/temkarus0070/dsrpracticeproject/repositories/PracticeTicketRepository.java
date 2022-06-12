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
    List<PracticeTicketProjection> findAllBy();

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketProjection> findAllByOrderByRecommendToHireAscFinalMarkAsc();

    @Query(value = "SELECT t.mentor.id,t.mentor.fullName,count(t.id.studentId) as studentsCount,count(CASE WHEN t.isRecommendToHire is true then 1 else 0)as successCount" +
            "  from PracticeTicket t join t.mentor group by t.mentor")
    List<MentorStudentsStatsProjection> findStatsByMentors();

    @Query(value = "SELECT pt.programmingLanguage as language,count(pt.student) as count from PracticeTicket pt group by pt.programmingLanguage")
    List<ProgrammingLanguageStatsProjection> findStatsByProgrammingLanguages();

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketProjection> findAllById_MentorId(long mentorId);

}
