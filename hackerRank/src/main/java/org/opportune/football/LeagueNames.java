package org.opportune.football;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.opportune.APICall.getAPIResponse;


public class LeagueNames {
    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/football_competitions";
    public static void main(String[] args) throws IOException {
        List<String> distinctLeagues =  fetchLeaguesFromAPI().stream()
                                                            .distinct()
                                                            .sorted()
                                                            .collect(Collectors.toList());
        System.out.println("Unique League Names:" + distinctLeagues);
    }
    public static List<String> fetchLeaguesFromAPI() throws IOException{
        List<String> leagues = new ArrayList<>();
        int page = 1;
        int totalPages;
        try {
            do {
                String url = String.format(BASE_URL + "?page=%d", page) ;
                JSONObject json = getAPIResponse(url);
                totalPages = json.getInt("total_pages");
                JSONArray data = json.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject league = data.getJSONObject(i);
                    leagues.add(league.getString("name"));
                }
                page++;
            } while (page <= totalPages);

            return leagues;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
 }
