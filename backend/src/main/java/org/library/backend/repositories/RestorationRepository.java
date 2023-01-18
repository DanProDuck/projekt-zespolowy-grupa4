package org.library.backend.repositories;

import org.library.backend.models.Person;
import org.library.backend.models.Restoration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface RestorationRepository extends JpaRepository<Restoration, Integer> {
    Optional<Restoration> findByPersonID(@NotNull Person personID);
}
