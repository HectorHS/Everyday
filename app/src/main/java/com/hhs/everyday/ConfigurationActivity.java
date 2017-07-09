package com.hhs.everyday;

import android.app.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.util.List;

/**
 * Created by Hecto on 25/06/2017.
 */
public class ConfigurationActivity extends AppCompatActivity implements TrackerTypeDialogFragment.TrackerTypeDialogListener{

    private List<TrackerItem> sharedTrackers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuration_activity);

        sharedTrackers = new SharedPreferencesManager(getSharedPreferences("trackersConfig", MODE_PRIVATE)).GetTrackers();

        ListAdapter configurationAdapter = new ConfigurationAdapter(this, sharedTrackers);

        // ListViews display data in a scrollable list
        ListView theListView = (ListView) findViewById(R.id.theConfigurationListView);

        // Tells the ListView what data to use
        theListView.setAdapter(configurationAdapter);
    }

public void onTrackerTypeButtonClick(View view)
{
    TrackerTypeDialogFragment typeDialog = new TrackerTypeDialogFragment();
    FragmentManager fragmentManager = getFragmentManager();
    typeDialog.show(fragmentManager, "trackerType");
}

    //For when the type is selected
    @Override
    public void onSelectionClick(DialogFragment dialog, String selected) {
        Button addTypeButton = (Button) findViewById(R.id.addTrackerTypeButton);
        addTypeButton.setText(selected);
    }

    public void addIconClicked(View view)
    {
        // Get inputed information and update the trackers list
        Button addTypeButton = (Button) findViewById(R.id.addTrackerTypeButton);
        TrackerType trackerType = TrackerType.valueOf(addTypeButton.getText().toString());
        EditText nameInput = (EditText) findViewById(R.id.addTrackerNameInput);
        String trackerName = nameInput.getText().toString();

        TrackerItem newTracker = new TrackerItem(trackerName, trackerType);
        sharedTrackers.add(newTracker);

        // Save the updated tracker to shared preferences
        new SharedPreferencesManager(getSharedPreferences("trackersConfig", MODE_PRIVATE)).UpdateTrackers(sharedTrackers);

        // Reload activity to see newly added tracker
        this.recreate();
    }
}
