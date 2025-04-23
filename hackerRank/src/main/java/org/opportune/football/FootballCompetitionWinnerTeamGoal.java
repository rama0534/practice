//https://jsonmock.hackerrank.com/api/football_matches
//First need to find the winner based on year and League name using https://jsonmock.hackerrank.com/api/football_competitions
//And then find the total goal of winner team.
//Total goals means team1(Host team) and team2(visiting team)
package org.opportune.football;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.opportune.APICall.getAPIResponse;

public class FootballCompetitionWinnerTeamGoal {
    private static final String COMPITITIONS_URL = "https://jsonmock.hackerrank.com/api/football_competitions";
    public static void main(String[] args) throws IOException {
        int year = 2011;
        String league = "English Premier League";
        String winnerTeam = getWinnerTeam(year, league);
        System.out.println("Year: "+ year + " Winner team: for league (" + league + ") is " + winnerTeam);
    }

    private static String getWinnerTeam(int year, String league) throws IOException {
        String winner;
        try {
            String encodedLeague = URLEncoder.encode(league, StandardCharsets.UTF_8);
            String urlString = String.format(COMPITITIONS_URL + "/?year=%d&name=%s", year, encodedLeague);
            JSONObject json = getAPIResponse(urlString);
            winner = json.getJSONArray("data").getJSONObject(0).getString("winner");
            return winner;
        }  catch (IOException | JSONException e) {
            throw new RuntimeException("Failed to fetch team data", e);
        }
    }

}
