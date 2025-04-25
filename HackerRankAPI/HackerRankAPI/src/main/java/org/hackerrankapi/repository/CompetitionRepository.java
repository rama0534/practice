package org.hackerrankapi.repository;

import org.hackerrankapi.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
}
