package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.repositories.MentorRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public void add(Mentor mentor) {
        mentorRepository.save(mentor);
    }

    public void update(Mentor mentor) {
        Optional<Mentor> mentorOptional = mentorRepository.findById(mentor.getId());
        Mentor mentor1 = mentorOptional.orElseThrow(EntityNotFoundException::new);
        mentor1.setJobName(mentor.getJobName());
        mentor1.setContactData(mentor.getContactData());
        mentor1.setFullName(mentor.getFullName());
        mentorRepository.save(mentor1);
    }
}
