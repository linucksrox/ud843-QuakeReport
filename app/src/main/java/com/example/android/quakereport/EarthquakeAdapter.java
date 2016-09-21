package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by edaly on 8/31/2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getName();

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String formattedMagnitude = decimalFormatter.format(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        String rawLocation = currentEarthquake.getLocation();
        String locationOffset, primaryLocation;
        if (rawLocation.contains(" of ")) {
            locationOffset = rawLocation.substring(0, rawLocation.indexOf(" of ") + 3);
            primaryLocation = rawLocation.substring(rawLocation.indexOf(" of ") + 4, rawLocation.length());
        }
        else {
            locationOffset = "Near the";
            primaryLocation = rawLocation;
        }
        locationOffsetView.setText(locationOffset);
        primaryLocationView.setText(primaryLocation);

        Date date = new Date(currentEarthquake.getDate());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(date);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(date);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(date);
    }

    private String formatTime(Date date) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        return timeFormatter.format(date);
    }

    private int getMagnitudeColor(double magnitude) {
        int magInt = (int) magnitude;
        switch (magInt) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            case 10:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }
}
