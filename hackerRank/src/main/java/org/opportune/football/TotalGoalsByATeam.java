//https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1
//Input
//Year and Team name.
//To access collection of match perform GET request https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team1=<team>&page=<page> and https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team2=<team>&page=<page>
//<year>: year of competition
//<team>: name of team
//<page>: page number of request
//team1 : home team
//team2 : visiting team
//Output
//Get all matches a particular team played.
//In order to get all matches a team played in , need to retrieve the matches where team was home team and the visiting team.
//totalGoals = team1goal(from 1st URL)+team2goal(from 2nd URL)
package org.opportune.football;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static org.opportune.APICall.getAPIResponse;

public class TotalGoalsByATeam {
    private static final String MATCH_URL = "https://jsonmock.hackerrank.com/api/football_matches";

    public static void main(String[] args) {
        String team = "Barcelona";
        int year = 2011;
        int totalGoals = getTotalGoals(team, year);
        System.out.println("Total goals scored by " + team + " in " + year + ": " + totalGoals);
    }

    public static int getTotalGoals(String team, int year) {
        int totalGoals = 0;
        // Check both home team (team1) and visiting team (team2)
        totalGoals += fetchGoals(team, year, "team1");
        totalGoals += fetchGoals(team, year, "team2");
        return totalGoals;
    }

    private static int fetchGoals(String team, int year, String teamType) {
        int goals = 0;
        int page = 1;
        int totalPages;
        try {
            do {
                String urlStr = String.format( MATCH_URL + "?year=%d&%s=%s&page=%d",
                        year, teamType, team, page
                );
                JSONObject json = getAPIResponse(urlStr);
                totalPages = json.getInt("total_pages");
                JSONArray data = json.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject match = data.getJSONObject(i);
                    String goalStr = match.getString(teamType + "goals");
                    goals += Integer.parseInt(goalStr);
                }
                page++;
            } while (page <= totalPages);

            return goals;
        } catch (IOException | JSONException e) {
            throw new RuntimeException("Failed to fetch team data", e);
        }
    }
}

