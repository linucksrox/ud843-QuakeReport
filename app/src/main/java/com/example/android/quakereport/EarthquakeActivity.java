/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

<<<<<<< HEAD
import android.content.Intent;
import android.net.Uri;
=======
import android.app.Activity;
import android.os.AsyncTask;
>>>>>>> 3c91c822935d8f4a7b81432136224235920497e1
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    public static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        EarthQuakeAsyncTask task = new EarthQuakeAsyncTask(this);
        task.execute(USGS_REQUEST_URL);
    }

    /**
     * Fetch data from USGS by running AsyncTask in background thread
     */
    private class EarthQuakeAsyncTask extends AsyncTask<String, Void, ArrayList<Earthquake>> {

        private Activity context;

        public EarthQuakeAsyncTask(Activity context) {
            this.context = context;
        }

        @Override
        protected ArrayList<Earthquake> doInBackground(String... urls) {
            // don't perform the request if there are no URLs or the first URL is null
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            // request data using QueryUtils methods
            ArrayList<Earthquake> earthquakeList = QueryUtils.fetchEarthquakeData(urls[0]);

            return earthquakeList;
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthquakes) {
            // Find a reference to the {@link ListView} in the layout
            ListView earthquakeListView = (ListView) findViewById(R.id.list);

<<<<<<< HEAD
        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        // set the onItemClickListener
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open the corresponding URL using an implicit intent
                Earthquake currentEarthquake = adapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(browserIntent);
            }
        });
=======
            // Create a new {@link ArrayAdapter} of earthquakes
            EarthquakeAdapter adapter = new EarthquakeAdapter(context, earthquakes);

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            earthquakeListView.setAdapter(adapter);
        }
>>>>>>> 3c91c822935d8f4a7b81432136224235920497e1
    }
}
