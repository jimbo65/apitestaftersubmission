package com.jobtest.answer;


import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;


public class Londoners {

    public static User[] getLondonUsers() {
        String users = "";
        try {

            URL url = new URL("https://bpdts-test-app.herokuapp.com/city/London/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            users = br.readLine();

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException io) {

            io.printStackTrace();

        }
        return UserUtils.buildUsers(users);
    }
}
