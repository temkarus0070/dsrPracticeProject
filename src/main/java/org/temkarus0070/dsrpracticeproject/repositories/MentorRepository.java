package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;
import org.temkarus0070.dsrpracticeproject.projections.MentorView;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    public MentorView findMentorById(long id);

    public List<MentorView> findAllBy();
}
