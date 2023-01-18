package org.library.backend.repositories.specification;

import org.library.backend.models.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.management.timer.Timer;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.TemporalAmount;

public class PersonSpecification {

//    public static Specification<Person> isSubscribed() {
//        return (root, query, builder) -> {
//            Instant monthAgo = Instant.now().minus(Period.ofMonths(1));
//            return builder.greaterThan(root.get(), monthAgo);
//        };
//    }
}
