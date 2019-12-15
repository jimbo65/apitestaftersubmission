package com.jobtest.answer;

import org.springframework.beans.factory.annotation.Value;

public class HaversineAlgorithm {
    static final double _eQuatorialEarthRadius = 3963.191D;
    static final double _degs2rads = (Math.PI / 180D);
    static final double ldnLat = 51.5074;
    static final double ldnLon = 0.1278;

    public static double haversineInMiles(double lat2, double long2) {
        double dlong = (long2 - ldnLon) * _degs2rads;
        double dlat = (lat2 - ldnLat) * _degs2rads;
        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(ldnLat * _degs2rads) * Math.cos(lat2 * _degs2rads)
                * Math.pow(Math.sin(dlong / 2D), 2D);
        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
        return _eQuatorialEarthRadius * c;
    }

}
