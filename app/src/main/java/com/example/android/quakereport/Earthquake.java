package com.example.android.quakereport;

/**
 * Created by eric on 8/31/16.
 */
public class Earthquake {
    private String magnitude;
    private String location;
    private String date;

    Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
