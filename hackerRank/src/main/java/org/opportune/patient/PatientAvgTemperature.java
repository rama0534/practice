package org.opportune.patient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static org.opportune.APICall.getAPIResponse;

public class PatientAvgTemperature {
     private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/medical_records";
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter userId to get temperature:");
            int userId = sc.nextInt();
            if (userId <= 0) {
                System.out.println("Invalid userId. Must be positive.");
                return;
            }
            System.out.println("Average body temperature for userId " + userId + " is: " + getTemperature(userId) + "°C");
        }
    }

    private static String getTemperature(int userId) throws IOException {
        double temperatureSum = 0.0;
        int page = 1;
        int totalPages;
        int count = 0;
        do {
            String url = String.format(BASE_URL + "?userId=%d&page=%d", userId, page);
            JSONObject json = getAPIResponse(url);
            totalPages = json.getInt("total_pages");
            JSONArray data = json.getJSONArray("data");
            if(!data.isEmpty()) {
                for (int i = 0; i < data.length(); i++) {
                    JSONObject record = data.getJSONObject(i);
                    JSONObject  vitals = record.getJSONObject("vitals");
                    temperatureSum += vitals.getDouble("bodyTemperature");
                    count++;
                }
            }
            page++;
        } while (page <= totalPages);
        return (count > 0) ? String.format("%.1f", temperatureSum / count) : "0";
    }
}
