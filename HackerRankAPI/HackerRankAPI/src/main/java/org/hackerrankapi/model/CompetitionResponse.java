package org.hackerrankapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Competition> data;
}

