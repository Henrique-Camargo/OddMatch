package dev.rick.OddMatch.repository;

import dev.rick.OddMatch.model.Houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepository extends JpaRepository<Houses, Long> {
}
