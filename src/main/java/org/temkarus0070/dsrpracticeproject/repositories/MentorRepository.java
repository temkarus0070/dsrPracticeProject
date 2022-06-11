package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
