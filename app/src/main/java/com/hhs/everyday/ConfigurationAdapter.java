package com.hhs.everyday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hecto on 27/05/2017.
 */
public class ConfigurationAdapter extends ArrayAdapter<TrackerItem> {
    private final Context context;
    private final List<TrackerItem> values;

    public ConfigurationAdapter(Context context, List<TrackerItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View concertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.configuration_row_layout, parent, false);
        TextView labelTextView = (TextView) rowView.findViewById(R.id.label);
        labelTextView.setText(values.get(position).getName());
        TextView typeTextView = (TextView) rowView.findViewById(R.id.type);
        typeTextView.setText(values.get(position).getType().toString());

        return rowView;
    }
}
