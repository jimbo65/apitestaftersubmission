package com.jobtest.answer;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserUtils {
    public JSONArray getUsersLocationWithinGivenDistance(JSONArray allUsers, double distance) {
        HaversineAlgorithm getDistance = new HaversineAlgorithm();
        JSONArray usersNearLondon = new JSONArray();
        for (int i = 0; i < allUsers.length(); i++) {
            JSONObject user = allUsers.getJSONObject(i);

            if (user.has("latitude") && user.has("longitude")) {
                Object lat = user.getDouble("latitude");
                Object lon = user.getDouble("longitude");
                if(lat instanceof Double && lon instanceof Double) {
                    if (getDistance.haversineInMiles((double)lat, (double)lon) < distance) {
                        usersNearLondon.put(user);
                    }
                }
            }
        }
        return usersNearLondon;
    }
}
