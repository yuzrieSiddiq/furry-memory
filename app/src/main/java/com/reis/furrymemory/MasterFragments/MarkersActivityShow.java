package com.reis.furrymemory.MasterFragments;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.reis.furrymemory.Adapters.MarkersListAdapter;
import com.reis.furrymemory.R;

import java.util.ArrayList;
import java.util.Calendar;

public class MarkersActivityShow extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private int _year, _month, _day;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.markers_show);

        /** initialize datepicker **/
        Calendar calendar = Calendar.getInstance();
        _year = calendar.get(Calendar.YEAR);
        _month= calendar.get(Calendar.MONTH);
        _day  = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, this, _year, _month, _day);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        ArrayAdapter<String> customAdapter = new MarkersListAdapter(getApplicationContext(), list, this);

        ListView listView = (ListView) findViewById(R.id.mylistview);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view, "Snackbar~ at ", Snackbar.LENGTH_LONG).show();
            }
        });

        Button newRecordBtn = (Button) findViewById(R.id.newrecord);
        newRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_newRecord();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {}

    public void onClick_newRecord() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MarkersActivityShow.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.markers_update_dialog, null);
        builder.setTitle("New Record");
        builder.setView(dialogView);

        final TextView item_title = (TextView) dialogView.findViewById(R.id.item_title);
        final EditText item_value_edit = (EditText) dialogView.findViewById(R.id.item_value_edit);
        final Button date_button = (Button) dialogView.findViewById(R.id.date_value_edit);
        item_value_edit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                        "OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == DialogInterface.BUTTON_POSITIVE) {
                                    DatePicker datePicker = datePickerDialog.getDatePicker();
                                    onDateSet(datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

                                    String date_string = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();
                                    date_button.setText(date_string);
                                }
                            }
                        });
                datePickerDialog.show();
            }
        });

        builder.setPositiveButton("Save", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
