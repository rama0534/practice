// https://jsonmock.hackerrank.com/api/movies/search
// https://jsonmock.hackerrank.com/api/movies/search/?Title=world&page=3
//Input
//To access the movie details by subtitle ,
//make a GET request to https://jsonmock.hackerrank.com/api/movies/search/?Title=substr&page=1
//Output
//List of movie names in ascending order
package org.opportune.movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.opportune.APICall.getAPIResponse;

public class Movies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title;
        System.out.println("Please enter movie subtitle ex: world.");
        title = scanner.next();
        List<String> movies = getMovies(title);
        Collections.sort(movies);
        System.out.println("Movies found: " + movies.size());
        movies.forEach(System.out::println);
    }

    public static List<String> getMovies(String title) {
        List<String> movies = new ArrayList<>();
        int page = 1;
        int totalPages = 1;
        try {
            String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
            do {
                String urlString = String.format("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d", encodedTitle, page);
                JSONObject json = getAPIResponse(urlString);
                totalPages = json.getInt("total_pages");
                JSONArray data = json.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                   JSONObject movie = data.getJSONObject(i);
                   movies.add(movie.getString("Title"));
                }
                page++;
            } while (page <= totalPages);
        } catch (IOException | JSONException e) {
            throw new RuntimeException("Failed to fetch movie data", e);
        }
        return movies;
    }
}
