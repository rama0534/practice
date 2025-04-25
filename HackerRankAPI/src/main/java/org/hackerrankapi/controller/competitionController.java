package org.hackerrankapi.controller;

import org.hackerrankapi.exceptions.InvalidPageSizeException;
import org.hackerrankapi.model.Competition;
import org.hackerrankapi.model.CompetitionResponse;
import org.hackerrankapi.service.CompetitionServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/football_competitions")
public class competitionController {
    public  final CompetitionServiceImpl service;

    public competitionController(CompetitionServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<CompetitionResponse> getCompetitions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if(size > 10)   throw new InvalidPageSizeException("Page size cannot exceed 10. Please enter a size ≤ 10.");
        Page<Competition> pagedResult = service.getPaginatedCompetitions(page, size);
        CompetitionResponse response = new CompetitionResponse();
        response.setData(pagedResult.getContent());
        response.setPage(pagedResult.getNumber());
        response.setPer_page(pagedResult.getSize());
        response.setTotal(pagedResult.getTotalElements());
        response.setTotal_pages(pagedResult.getTotalPages());


        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition>  getCompetition(@PathVariable int id) {
        return service.getByCompetitionId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createCompetition() {
        String response = service.addBulkCompetitions();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> update(@RequestBody Competition competitionDetails, @PathVariable int id) {
        Competition updatedCompetition = service.updateCompetition(id, competitionDetails);
        System.out.println();
        return ResponseEntity.ok(updatedCompetition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable int id) {
        service.deleteCompetition(id);
        return ResponseEntity.noContent().build();
    }
}
