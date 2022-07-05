package org.temkarus0070.dsrpracticeproject.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.temkarus0070.dsrpracticeproject.security.entities.User;
import org.temkarus0070.dsrpracticeproject.security.projections.UserProjection;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<UserProjection> findUserByUsername(String id);
}
