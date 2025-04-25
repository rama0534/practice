package org.hackerrankapi.service;

import org.hackerrankapi.model.Competition;

import java.util.Optional;

public interface ICompetitionService {
    Optional<Competition> getByCompetitionId(int competitionId);
    Competition updateCompetition(int competitionId, Competition competition);
    void deleteCompetition(int competitionId);
}
