package dev.rick.OddMatch.repository;

import dev.rick.OddMatch.model.Bets;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetsRepository extends JpaRepository<Bets, Long> {

        @EntityGraph(attributePaths = {"accounts", "houses", "event"})
        List<Bets> findAll();

}
