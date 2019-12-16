package com.jobtest.answer;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserUtils {
    public JSONArray getUsersLocationWithinGivenDistance(JSONArray allUsers, double distance) {
        HaversineAlgorithm getDistance = new HaversineAlgorithm();
        JSONArray usersNearLondon = new JSONArray();
        for (int i = 0; i < allUsers.length(); i++) {
            JSONObject user = allUsers.getJSONObject(i);
            double lat = user.getDouble("latitude");
            double lon = user.getDouble("longitude");
            if (getDistance.haversineInMiles(lat, lon) < distance) {
                usersNearLondon.put(user);
            }
        }
        return usersNearLondon;
    }
}
