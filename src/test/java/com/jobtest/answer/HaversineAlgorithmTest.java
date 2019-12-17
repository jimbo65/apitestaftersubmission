package com.jobtest.answer;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HaversineAlgorithmTest {

    HaversineAlgorithm haversine = new HaversineAlgorithm();

    @Test
    public void haversineInMilesReturnsCorrectDistanceLondonToManchester() {
        double manLat = 53.4808;
        double manLon = 2.2426;
        assertThat((double) Math.round(haversine.haversineInMiles(manLat, manLon)), is(equalTo(163D)));
    }

    @Test
    public void haversineInMilesReturnsCorrectDistanceLondonToNorwich() {
        double norLat = 52.6309;
        double norLon = -1.2974;
        assertThat((double) Math.round(haversine.haversineInMiles(norLat, norLon)), is(equalTo(99D)));
    }

    @Test
    public void haversineInMilesReturnsCorrectDistanceLondonToLeatherhead() {
        double leathLat = 51.2964;
        double leathLon = 0.3311;
        assertThat((double) Math.round(haversine.haversineInMiles(leathLat, leathLon)), is(equalTo(17D)));
    }
}