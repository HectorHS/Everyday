package com.hhs.everyday;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

    private  List<TrackerItem> getTrackers()
    {
        List<TrackerItem> list = new ArrayList<TrackerItem>();
        list.add(get("Happy", TrackerTypes.spectrum));
        list.add(get("Rested", TrackerTypes.spectrum));
        list.add(get("Clarity", TrackerTypes.spectrum));
        list.add(get("Food", TrackerTypes.text));

        return list;
    }
    private TrackerItem get(String name, TrackerTypes type) {
        return new TrackerItem(name, type);
    }
}
