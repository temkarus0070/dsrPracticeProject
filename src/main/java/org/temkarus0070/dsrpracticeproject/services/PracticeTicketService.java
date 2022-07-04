package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;
import org.temkarus0070.dsrpracticeproject.projections.PracticeTicketView;
import org.temkarus0070.dsrpracticeproject.repositories.PracticeTicketRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PracticeTicketService {
    @Autowired
    private PracticeTicketRepository practiceTicketRepository;
    @Autowired
    private MentorService mentorService;

    public void add(PracticeTicket practiceTicket) {
        if (practiceTicket.getPracticeTask() != null)
            practiceTicket.getPracticeTask().setPracticeTicket(practiceTicket);
        practiceTicketRepository.save(practiceTicket);
    }

    public PracticeTicketView get(PracticeTicket.PracticeTicketId practiceTicketId) {
        return practiceTicketRepository.findPracticeTicketById(practiceTicketId);
    }

    public List<PracticeTicketView> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities().stream().filter(e -> e.getAuthority().equalsIgnoreCase("admin")).count() > 0) {
            return practiceTicketRepository.findAllPracticeTicketBy();
        } else
            return getAllTicketsAssignedToMentor(mentorService.getMentorFromUsername(authentication.getName()).getId());

    }

    public List<PracticeTicketView> getAllTicketsAssignedToMentor(long mentorId) {
        return practiceTicketRepository.findAllPracticeTicketById_MentorId(mentorId);
    }

public List<PracticeTicketView> getAllTicketsAssignedToStudent(long id) {
    return practiceTicketRepository.findAllById_StudentId(id);
}

    public void update(PracticeTicket practiceTicket) {
        PracticeTicket practiceTicket1 = practiceTicketRepository.findById(practiceTicket.getId()).orElseThrow(EntityNotFoundException::new);
        practiceTicket1.setFinalMark(practiceTicket.getFinalMark());
        practiceTicket1.setRecommendToHire(practiceTicket.isRecommendToHire());
        practiceTicket1.setPracticeTask(practiceTicket.getPracticeTask());
        practiceTicket.getPracticeTask().setPracticeTicket(practiceTicket1);
        practiceTicket1.setWeeklyMentorReviews(practiceTicket.getWeeklyMentorReviews());
        practiceTicket1.setFinalMentorReview(practiceTicket.getFinalMentorReview());
        practiceTicketRepository.save(practiceTicket1);
    }

    public void delete(PracticeTicket.PracticeTicketId id) {
        practiceTicketRepository.deleteById(id);
    }
}
