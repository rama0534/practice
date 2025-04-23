package org.opportune.football;

import org.json.JSONObject;
import java.io.IOException;
import static org.opportune.APICall.getAPIResponse;

public class NumberOfDrawnMatches {
    private static final String MATCH_URL = "https://jsonmock.hackerrank.com/api/football_matches";
    public static void main(String[] args) {
        int year = 2011;
        int drawMatches = getDrawMatches(year);
        System.out.println("Total Draw matches in the year: " + year + " is " + drawMatches);
    }

    public static int getDrawMatches(int year) {
        int drawMatches = 0;
        try {
            int totalGoals = 10;
            for (int goal = 0; goal <= totalGoals; goal++) {
                String url = String.format(MATCH_URL +"?year=%d&team1goals=%d&team2goals=%d", year, goal, goal);
                JSONObject json = getAPIResponse(url);
                drawMatches += json.getInt("total");
            }
            return drawMatches;
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
