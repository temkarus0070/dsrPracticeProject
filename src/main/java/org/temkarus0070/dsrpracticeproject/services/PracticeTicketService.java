package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.PracticeTicketStats;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeResultView;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;
import org.temkarus0070.dsrpracticeproject.repositories.PracticeTicketRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class PracticeTicketService {
    @Autowired
    private PracticeTicketRepository practiceTicketRepository;

    public void add(PracticeTicket practiceTicket) {
        practiceTicketRepository.save(practiceTicket);
    }

    public PracticeTicketView get(PracticeTicket.PracticeTicketId practiceTicketId) {
        return practiceTicketRepository.findPracticeTicketById(practiceTicketId);
    }

    public List<PracticeTicketView> getAll() {
        return practiceTicketRepository.findAllPracticeTicketBy();
    }

    public List<PracticeTicketView> getAllTicketsAssignedToMentor(long mentorId) {
        return practiceTicketRepository.findAllPracticeTicketById_MentorId(mentorId);
    }

    public List<PracticeResultView> getRatingOfStudents(LocalDate practiceBegin,LocalDate practiceEnd) {
        return practiceTicketRepository.findAllById_BeginOfPracticeIsAndId_EndOfPracticeIsLessThanEqualOrderByRecommendToHireDescFinalMarkDesc(practiceBegin,practiceEnd);
    }

    public   List<MentorStudentsStatsView> getStatsByMentors(LocalDate practiceBegin,LocalDate practiceEnd) {
        return practiceTicketRepository.findStatsByMentors(practiceBegin,practiceEnd);
    }

    public   List<ProgrammingLanguageStatsView> getStatsByProgrammingLanguage(LocalDate practiceBegin,LocalDate practiceEnd){
        return practiceTicketRepository.findStatsByProgrammingLanguages(practiceBegin,practiceEnd);
    }

    public void update(PracticeTicket practiceTicket) {
        PracticeTicket practiceTicket1 = practiceTicketRepository.findById(practiceTicket.getId()).orElseThrow(EntityNotFoundException::new);
        practiceTicket1.setFinalMark(practiceTicket.getFinalMark());
        practiceTicket1.setRecommendToHire(practiceTicket.isRecommendToHire());
        practiceTicket1.setTaskName(practiceTicket.getTaskName());
        practiceTicket1.setWeeklyMentorReviews(practiceTicket.getWeeklyMentorReviews());
        practiceTicket1.setFinalMentorReview(practiceTicket.getFinalMentorReview());
        practiceTicketRepository.save(practiceTicket1);
    }

    public void delete(PracticeTicket.PracticeTicketId id) {
        practiceTicketRepository.deleteById(id);
    }
}
