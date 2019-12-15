package com.jobtest.answer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserUtilsTest {

    String testData = "[{\"id\": 1, \"first_name\": \"First1\", \"last_name\": \"WithinFiftyMilesOfLondon\", \"email\": \"first1@dummy.com\", \"ip_address\": \"192.10.10.1\", \"latitude\": 51.2964, \"longitude\": 0.3311}, {\"id\": 2, \"first_name\": \"First2\", \"last_name\": \"Last2\", \"email\": \"first2@dummy.com\", \"ip_address\": \"192.10.10.2\", \"latitude\": -2.9623869, \"longitude\": 104.7399789}, {\"id\": 3, \"first_name\": \"First3\", \"last_name\": \"Last3\", \"email\": \"first3@dummy.com\", \"ip_address\": \"192.10.10.3\", \"latitude\": \"15.45033\", \"longitude\": \"44.12768\"}]";

    @Test
    public void buildUsersConvertsJsonStringToCorrectNumberOfUsers() {
       User[] testUsers = UserUtils.buildUsers(testData);
       assertThat(testUsers.length,is(equalTo(3)));
    }

    @Test
    public void buildUsersCloseToLondonOnlyBuildsUsersWHoAreWithinAGivenDistanceOfLondon() {
        User[] testUsers = UserUtils.buildUsersCloseToLondon(testData,50D);
        assertThat(testUsers.length,is(equalTo(1)));
        assert(testUsers[0].getLast_name().equals("WithinFiftyMilesOfLondon"));

    }
}