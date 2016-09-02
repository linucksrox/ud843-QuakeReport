package com.example.android.quakereport;

/**
 * Created by eric on 8/31/16.
 */
public class Earthquake {
    private String magnitude;
    private String location;
    private long time;

    Earthquake(String magnitude, String location, long time) {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return time;
    }
}
