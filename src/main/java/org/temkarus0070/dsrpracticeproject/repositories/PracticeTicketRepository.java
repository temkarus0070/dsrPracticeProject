package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PracticeTicketRepository extends JpaRepository<PracticeTicket, PracticeTicket.PracticeTicketId> {
    @EntityGraph("practiceTickerGraph")
    PracticeTicketView findPracticeTicketById(PracticeTicket.PracticeTicketId id);

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketView> findAllPracticeTicketBy();

    List<PracticeResultView> findAllById_BeginOfPracticeIsGreaterThanEqualAndId_EndOfPracticeIsLessThanEqualOrderByRecommendToHireDescFinalMarkDesc(LocalDate beginPractice, LocalDate endPractice);

    @Query(value = "SELECT t.mentor.id as mentorId,t.mentor.fullName as fullName,count(t.id.studentId) as studentsCount,SUM(CASE when t.recommendToHire is true then  1 else 0 end)" +
            "as successStudentsCount" +
            "  from PracticeTicket t WHERE t.id.beginOfPractice >= :beginPractice and t.id.endOfPractice<= :endPractice group by t.mentor.id,t.mentor.fullName")
    List<MentorStudentsStatsView> findStatsByMentors(LocalDate beginPractice, LocalDate endPractice);


    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketView> findAllPracticeTicketById_MentorId(long mentorId);

    @EntityGraph("practiceTickerGraph")
    List<PracticeTicketView> findAllById_StudentId(long id);
}
