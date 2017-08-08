package com.reis.furrymemory.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.reis.furrymemory.MasterFragments.MarkersActivityShow;
import com.reis.furrymemory.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by reis on 07/08/2017.
 */

public class MarkersListAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> strings;
    private MarkersActivityShow markersActivityShow;
    // activity is required (not context) for the alertdialog

    public MarkersListAdapter(@NonNull Context context, ArrayList<String> values, MarkersActivityShow markersActivityShow) {
        super(context, R.layout.markers_show_list_fragments, values);
        this.context = context;
        this.strings = values;
        this.markersActivityShow = markersActivityShow;
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
                String title = "Title";
                String message = "Message";

                onClick_showDialog(title, message);
            }
        });

        return view;
    }

    public void onClick_showDialog(String title, String message) {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(markersActivityShow, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
//        alertDialogBuilder
//                .setTitle(title)
//                .setMessage(message)
//                .setCancelable(true)
//                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        // create the dialog prompt
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(markersActivityShow, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        LayoutInflater inflater = markersActivityShow.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.markers_comments, null);
        builder.setView(dialogView);

        builder.setCancelable(true);
        builder.setNegativeButton("Close", null);
        builder.show();
    }
}
