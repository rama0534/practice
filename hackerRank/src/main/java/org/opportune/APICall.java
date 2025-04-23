package org.opportune;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICall {
    public static JSONObject getAPIResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        )) {
            StringBuilder content = new StringBuilder();
            String lineRead;
            while ((lineRead = bufferedReader.readLine()) != null) {
                content.append(lineRead);
            }
            return new JSONObject(content.toString());
        } finally {
            connection.disconnect();
        }
    }
}
