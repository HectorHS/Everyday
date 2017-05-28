package com.hhs.everyday;

import android.content.Context;
import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
        View rowView = inflater.inflate(R.layout.tracker_row_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);


        EditText editText = (EditText) rowView.findViewById(R.id.input);
        if(values.get(position).getType() == TrackerTypes.text)
        {
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setWidth(80);
        }
        else
        {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setWidth(40);
            editText.setText("0");
        }
        textView.setText(values.get(position).getName());


        return rowView;
    }
}
