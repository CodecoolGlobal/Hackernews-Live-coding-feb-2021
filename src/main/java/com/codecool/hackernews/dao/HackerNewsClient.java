package com.codecool.hackernews.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HackerNewsClient {

    public static final String API_BASE_URL = "https://api.hnpwa.com/v0/";

    public String getJsonResponse(String endpoint, int page) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(API_BASE_URL + endpoint + "/" + page + ".json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line = in.readLine();
                while (line != null) {
                    response.append(line);
                    line = in.readLine();
                }
            }
            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}
