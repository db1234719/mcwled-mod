package com.example.wledmod;

import java.net.HttpURLConnection;
import java.net.URL;

public class WLEDAPI {
    private static final String WLED_API_URL = "http://192.168.1.110/json/state";

    public static void sendWLEDEvent(String event) {
        try {
            URL url = new URL(WLED_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String json = switch (event) {
                case "plains" -> "{\"seg\": [{\"fx\": 1, \"col\": [[34, 139, 34]]}]}";
                case "fire_damage" -> "{\"seg\": [{\"fx\": 54, \"col\": [[255, 0, 0]]}]}";
                // Add more events here...
                default -> "{\"seg\": [{\"col\": [[255, 255, 255]]}]}";
            };

            connection.getOutputStream().write(json.getBytes());
            connection.getInputStream(); // Trigger request
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
