package com.jobtest.answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserUtilsTest {

    @Test
    public void buildUsersCloseToLondonOnlyBuildsUsersWHoAreWithinAGivenDistanceOfLondon() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": -2.9623869, \"longitude\": 104.7399789}, {\"last_name\": \"Last3\", \"latitude\": \"15.45033\", \"longitude\": \"44.12768\"}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data,50D);
        assertThat(testUsers.length(),is(equalTo(1)));
        assert(testUsers.getJSONObject(0).getString("last_name").equals("WithinFiftyMilesOfLondon"));

    }

}