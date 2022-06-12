package org.temkarus0070.dsrpracticeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.entities.PracticeTicket;

@Repository
public interface PracticeTicketRepository extends JpaRepository<PracticeTicket, PracticeTicket.PracticeTicketId> {
}
