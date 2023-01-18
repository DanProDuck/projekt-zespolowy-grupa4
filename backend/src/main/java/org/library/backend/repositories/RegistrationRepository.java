package org.library.backend.repositories;

import org.library.backend.models.Person;
import org.library.backend.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
 Optional<Registration> findByPersonID(@NotNull Person personID);
}