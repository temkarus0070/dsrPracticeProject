package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketProjection;
import org.temkarus0070.dsrpracticeproject.repositories.PracticeTicketRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PracticeTicketService {
    @Autowired
    private PracticeTicketRepository practiceTicketRepository;

    public void add(PracticeTicket practiceTicket) {
        practiceTicketRepository.save(practiceTicket);
    }

    public PracticeTicketProjection get(PracticeTicket.PracticeTicketId practiceTicketId) {
        return practiceTicketRepository.findPracticeTicketById(practiceTicketId);
    }

    public List<PracticeTicketProjection> getAll() {
        return practiceTicketRepository.findAllPracticeTicketBy();
    }

    public List<PracticeTicketProjection> getAllTicketsAssignedToMentor(long mentorId) {
        return practiceTicketRepository.findAllById_MentorId(mentorId);
    }

    public List<PracticeTicketProjection> getAllTicketsSortedByStudiedResults() {
return practiceTicketRepository.findAllByOrderByRecommendToHireAscFinalMarkAsc();
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
