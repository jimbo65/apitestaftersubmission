package com.jobtest.answer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("id")
    private int id;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("email")
    private String email;
    @JsonProperty("ip_address")
    private String ip_address;

    public User() { }

    @JsonProperty("first_name")
    public String getFirst_name() {
        return first_name;
    }

    @JsonProperty("first_name")
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @JsonProperty("last_name")
    public String getLast_name() {
        return last_name;
    }

    @JsonProperty("last_name")
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("ip_address")
    public String getIp_address() {
        return ip_address;
    }

    @JsonProperty("ip_address")
    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}

