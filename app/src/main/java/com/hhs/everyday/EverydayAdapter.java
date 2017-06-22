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
public class EverydayAdapter extends ArrayAdapter<TrackerItem>
{
    private final Context context;
    private final List<TrackerItem> values;

    public EverydayAdapter(Context context, List<TrackerItem> values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View concertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(values.get(position).getType() == TrackerType.text)
        {
            View rowView = inflater.inflate(R.layout.tracker_row_layout_text, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            textView.setText(values.get(position).getName());
            return rowView;
        }
        else
        {
            View rowView = inflater.inflate(R.layout.row_number, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label_number);
            textView.setText(values.get(position).getName());
            return rowView;
        }


    }
}
