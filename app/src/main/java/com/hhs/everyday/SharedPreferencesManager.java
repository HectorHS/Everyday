package com.hhs.everyday;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Hecto on 09/07/2017.
 */
public class SharedPreferencesManager {

    SharedPreferences sharedPreferences;

    public SharedPreferencesManager (SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void UpdateTrackers (List<TrackerItem> allTrackers) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(allTrackers);
        prefsEditor.putString("trackers", json);
        prefsEditor.commit();
    }

    public List<TrackerItem> GetTrackers() {
        List<TrackerItem> sharedTrackers;

        Gson gson = new Gson();
        String json = sharedPreferences.getString("trackers", null);
        Type type = new TypeToken<ArrayList<TrackerItem>>() {}.getType();
        sharedTrackers = gson.fromJson(json, type);

        return sharedTrackers;
    }
}
