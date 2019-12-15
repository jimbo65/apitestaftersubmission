package com.jobtest.answer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserUtils {
    public static User[] buildUsers(String jsonUsers) {
        User[] userList = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            userList = mapper.readValue(jsonUsers, User[].class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static User[] buildUsersCloseToLondon(String users, double distance) {
        User[] allUsers = buildUsers(users);
        return getUsersLocationWithinGivenDistance(allUsers, distance);
    }

    private static User[] getUsersLocationWithinGivenDistance(User[] allUsers, double distance) {
        Stream<User> usersStream = Arrays.stream(allUsers);
        Stream<User> usersWithinDistanceStream = usersStream.filter(x -> HaversineAlgorithm.haversineInMiles(x.getLatitude(), x.getLongitude()) < distance);
        return usersWithinDistanceStream.toArray(User[]::new);
    }
}
