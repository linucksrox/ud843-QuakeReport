package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by edaly on 1/20/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String url;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        // don't perform the request if there are no URLs or the first URL is null
        if (url == null) {
            return null;
        }

        // request data using QueryUtils methods
        List<Earthquake> earthquakeList = QueryUtils.fetchEarthquakeData(url);

        return earthquakeList;
    }
}
