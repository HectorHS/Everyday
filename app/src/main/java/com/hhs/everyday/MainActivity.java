package com.hhs.everyday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import org.xml.sax.InputSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter theAdapter = new EverydayAdapter(this, getTrackers());

        // ListViews display data in a scrollable list
        ListView theListView = (ListView) findViewById(R.id.theListView);

        // Tells the ListView what data to use
        theListView.setAdapter(theAdapter);
    }

    private List<TrackerItem> getTrackers() {
        List<TrackerItem> trackersList = new ArrayList<TrackerItem>();
        try
        {
            InputStream inputStream = getAssets().open("today.xml");
            InputSource inputSource = new InputSource(inputStream);
            XMLParser xml = new XMLParser(inputSource);
            trackersList = xml.readXml();
        }
        // TODO Handle exceptions properly
         catch (IOException e) {
            e.printStackTrace();
        }

        return trackersList;
    }
}
