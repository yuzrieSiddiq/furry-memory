package com.reis.furrymemory.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.reis.furrymemory.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by reis on 07/08/2017.
 */

public class MarkersListAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> strings;

    public MarkersListAdapter(@NonNull Context context, ArrayList<String> values) {
        super(context, R.layout.markers_show_list_fragments, values);
        this.context = context;
        this.strings = values;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.markers_show_list_fragments, parent, false);

        TextView markerValue = (TextView) view.findViewById(R.id.marker_value);
        TextView markerTimestamp = (TextView) view.findViewById(R.id.marker_timestamp);
        ImageView commentIcon = (ImageView) view.findViewById(R.id.comment_icon);

        markerValue.setText("Test");
        commentIcon.setClickable(true);
        commentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_showDialog("1", "Test");
            }
        });

        Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show();

        return view;
    }

    public void onClick_showDialog(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create the dialog prompt
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
