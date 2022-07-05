package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.projections.MentorView;
import org.temkarus0070.dsrpracticeproject.repositories.MentorRepository;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.services.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private UserService userService;

    public void add(Mentor mentor) {
        mentorRepository.save(mentor);
    }

    public MentorView get(long id) {
        return mentorRepository.findMentorById(id);
    }

    public Mentor getMentor(long id) {
        return mentorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("не найдено ментора с таким id"));
    }

    public List<MentorView> getNewlyRegistrated() {
        return mentorRepository.findAllByUserIsNotNullAndUser_ActiveIsFalse();
    }

    public List<MentorView> getAll() {
        return mentorRepository.findAllByUserIsNotNullAndUser_ActiveTrueOrUserIsNull();
    }

    public void update(Mentor mentor, long id) {
        Optional<Mentor> mentorOptional = mentorRepository.findById(id);
        Mentor mentor1 = mentorOptional.orElseThrow(EntityNotFoundException::new);
        mentor1.setJobName(mentor.getJobName());
        mentor1.setContactData(mentor.getContactData());
        mentor1.setFullName(mentor.getFullName());
        mentorRepository.save(mentor1);
    }

    public Mentor getMentorFromUsername(String login) {
        return mentorRepository.findByUserIsNotNullAndUser_Username(login);
    }

    public void delete(long id) {
        User user = mentorRepository.findById(id).get().getUser();
        mentorRepository.deleteById(id);
        userService.deleteUser(user.getUsername());
    }
}
