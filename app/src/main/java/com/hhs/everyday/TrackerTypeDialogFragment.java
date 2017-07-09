package com.hhs.everyday;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Hecto on 05/07/2017.
 */
public class TrackerTypeDialogFragment extends DialogFragment {

    public interface TrackerTypeDialogListener {
        void onSelectionClick(DialogFragment dialog, String type);
    }

    TrackerTypeDialogListener tListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] types = TrackerType.getStringValues();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a type")
                .setItems(types, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {

                        String selected = types[i];

                        tListener.onSelectionClick(TrackerTypeDialogFragment.this, selected);
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            tListener = (TrackerTypeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    //TODO implement properly!
                    + " must implement NoticeDialogListener");
        }
    }
}
