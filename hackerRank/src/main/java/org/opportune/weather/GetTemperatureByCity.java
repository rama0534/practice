package org.opportune.weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.opportune.APICall.getAPIResponse;

public class GetTemperatureByCity {
    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/weather";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a city name to find its temperature (e.g., Dallas or Denver):");
        String city = sc.nextLine();
        String temperature = getTemperatureByCity(city);
        if (temperature != null) {
            System.out.println("Temperature in " + city + " is " + temperature + "°");
        } else {
            System.out.println("City '" + city + "' not found or data unavailable.");
        }
    }
    private static String getTemperatureByCity(String city) {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String urlString = String.format(BASE_URL + "?name=%s", encodedCity);
            JSONObject json = getAPIResponse(urlString);
            JSONArray data = json.getJSONArray("data");
            if (data.isEmpty()) {
                System.out.println("City not found: " + city);
                return null;
            }
            String weather = data.getJSONObject(0).getString("weather");
            return weather.replaceAll("[^\\-0-9]", ""); // keep "-" and digits only
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
