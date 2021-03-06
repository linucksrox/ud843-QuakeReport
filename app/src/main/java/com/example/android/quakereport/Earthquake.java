package com.example.android.quakereport;

/**
 * Created by eric on 8/31/16.
 */
public class Earthquake {
    private Double magnitude;
    private String location;
    private long time;
    private String url;

    Earthquake(Double magnitude, String location, long time, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
        this.url = url;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return time;
    }

    public String getUrl() {
        return url;
    }
}
