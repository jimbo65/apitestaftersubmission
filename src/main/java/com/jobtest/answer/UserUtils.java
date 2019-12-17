package com.jobtest.answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserUtils {
    public JSONArray getUsersLocationWithinGivenDistance(JSONArray allUsers, double distance) {
        HaversineAlgorithm getDistance = new HaversineAlgorithm();
        JSONArray usersNearLondon = new JSONArray();

        for (int i = 0; i < allUsers.length(); i++) {
            JSONObject user = allUsers.getJSONObject(i);

            if (user.has("latitude") && user.has("longitude")) {
                try {
                    double lat = user.getDouble("latitude");
                    double lon = user.getDouble("longitude");

                    if (isBetween(lat, -90, 90) && isBetween(lon, -180, 180)) {
                        if (getDistance.haversineInMiles(lat, lon) < distance) {
                            usersNearLondon.put(user);
                        }
                    }

                } catch (JSONException e) {
                    System.out.println("Invalid co-ordinates in user record " + user.toString());
                }

            }

        }
        return usersNearLondon;
    }

    public boolean isBetween(double value, double min, double max) {

        return ((value >= min) && (value <= max));
    }

}
