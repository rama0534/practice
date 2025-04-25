package org.hackerrankapi.service;

import org.hackerrankapi.model.Competition;
import org.hackerrankapi.model.CompetitionResponse;
import org.hackerrankapi.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements ICompetitionService {
    @Value("${service.baseurl}")
    private String BASE_URL;

    private final CompetitionRepository repository;
    private final RestTemplate restTemplate;

    public CompetitionServiceImpl(CompetitionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public List<Competition> getPaginatedCompetitions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Competition> competitions = repository.findAll(pageable);
        return competitions.getContent();
    }

    @Override
    public Optional<Competition> getByCompetitionId(int competitionId) {
        return Optional.ofNullable(repository.findById(competitionId)
                .orElseThrow(() -> new RuntimeException("Competition with id:" + competitionId + " not found")));
    }

    public String addBulkCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        int page = 1;
        int totalPage;
        System.out.println(BASE_URL + "..");
        do {
            String url = String.format(BASE_URL+"?page=%d", page);
            ResponseEntity<CompetitionResponse> response = restTemplate.getForEntity(url, CompetitionResponse.class);
            CompetitionResponse body = response.getBody();
            System.out.println("body"+body);
            if(body != null) {
                competitions.addAll(body.getData());
                totalPage = body.getTotal_pages();
            }else {
                totalPage = 0;
            }
            page++;
        } while (page <= totalPage);
        repository.saveAll(competitions);
        return "All Competitions add to database";
    }

    @Override
    public Competition updateCompetition(int competitionId, Competition competitionDetails) {
        Competition competition = repository.findById(competitionId)
                                    .orElseThrow(() ->
                                            new RuntimeException("Competition not found with id: " + competitionId));
        if(competitionDetails.getName() != null) competition.setName(competitionDetails.getName());
        if(competitionDetails.getYear() != 0) competition.setYear(competitionDetails.getYear());
        if(competitionDetails.getCountry() != null) competition.setCountry(competitionDetails.getCountry());
        if(competitionDetails.getRunnerup() != null) competition.setRunnerup(competitionDetails.getRunnerup());
        if(competitionDetails.getWinner() != null) competition.setWinner(competitionDetails.getWinner());
        return repository.save(competition);
    }

    @Override
    public void deleteCompetition(int competitionId) {
        repository.deleteById(competitionId);
    }
}
