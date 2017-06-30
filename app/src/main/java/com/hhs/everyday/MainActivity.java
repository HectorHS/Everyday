package com.hhs.everyday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    // This method creates the menu on the app
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }

    // Called when a options menu item is selected
	    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            // We check what menu item was clicked and show a Toast
            if (id == R.id.action_settings) {

                Intent i=new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);

        	    return true;
            } else {
        	            return false;
        	        }
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
