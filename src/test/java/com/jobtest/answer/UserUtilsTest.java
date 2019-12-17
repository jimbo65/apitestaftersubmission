package com.jobtest.answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserUtilsTest {

    @Test
    public void buildUsersCloseToLondonOnlyBuildsUsersWHoAreWithinAGivenDistanceOfLondon() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": -2.9623869, \"longitude\": 104.7399789}, {\"last_name\": \"Last3\", \"latitude\": 15.45033, \"longitude\": 44.12768}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(1)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyIgnoresUsersWithoutLatitudeAndLongitudeKey() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\"}, {\"last_name\": \"Last3\",  \"latitude\": 51.2964, \"longitude\": 0.3311}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311},{\"last_name\": \"Last3\",  \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(2)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyIgnoresUsersWithoutLatitudeOrLongitudeKey() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": -2.9623869}, {\"last_name\": \"Last3\",  \"latitude\": 51.2964}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(1)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyWithLatitudeOrLongitudeAsANumberString() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": \"51.2964\", \"longitude\": \"0.3311\"}, {\"last_name\": \"Last3\", \"latitude\": 15.45033, \"longitude\": 44.12768}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": \"51.2964\", \"longitude\": \"0.3311\"}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(2)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyWithLatitudeOrLongitudeAsANonNumberString() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": \"Big\", \"longitude\": \"Small\"}, {\"last_name\": \"Last3\", \"latitude\": 15.45033, \"longitude\": 44.12768}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(1)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyWithLatitudeOrLongitudeAsNull() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": \"51.2964\", \"longitude\": \"null\" }, {\"last_name\": \"Last3\", \"latitude\": \"null\", \"longitude\": 0.3311}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(1)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonOnlyWithLatitudeOrLongitudeAsEmpty() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"last_name\": \"Last2\", \"latitude\": \"51.2964\", \"longitude\": \"\" }, {\"last_name\": \"Last3\", \"latitude\": \"\", \"longitude\": 0.3311}]");
        JSONArray expectedData = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 0.3311}]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(1)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);

    }

    @Test
    public void buildUsersCloseToLondonReturnsEmptyArrayWhenNoUsersFoundWithnFiftyMiles() throws JSONException {
        JSONArray data = new JSONArray("[{\"last_name\": \"WithinFiftyMilesOfLondon\", \"latitude\": 51.2964, \"longitude\": 45.3311}]");
        JSONArray expectedData = new JSONArray("[]");

        UserUtils util = new UserUtils();
        JSONArray testUsers = util.getUsersLocationWithinGivenDistance(data, 50D);
        assertThat(testUsers.length(), is(equalTo(0)));
        JSONAssert.assertEquals(testUsers, expectedData, JSONCompareMode.LENIENT);
    }
}