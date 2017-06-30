package com.hhs.everyday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hecto on 25/06/2017.
 */
public class SettingsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ListAdapter settingsAdapter = new SettingsAdapter(this, getTrackers());

        // ListViews display data in a scrollable list
        ListView theListView = (ListView) findViewById(R.id.theSettingsListView);

        // Tells the ListView what data to use
        theListView.setAdapter(settingsAdapter);
    }

    private List<TrackerItem> getTrackers() {
        List<TrackerItem> trackersList = new ArrayList<TrackerItem>();
        try
        {
            trackersList = new TrackerManager().getTrackersFromXML(getAssets().open("today.xml"));
        }
        // TODO Handle exceptions properly
        catch (IOException e) {
            e.printStackTrace();
        }

        return trackersList;
    }
}
