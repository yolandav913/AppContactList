package com.example.mycontactlist;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DatePickerDialog extends DialogFragment {


    Calendar selectedDate;

    public interface SaveDateListener {
        void didFinishDatePickerDialog(Calendar selectedTime);
    }

    public DatePickerDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.select_date, container);

        getDialog().setTitle("Select Date");
        final DatePicker dp= (DatePicker)view.findViewById(R.id.birthdayPicker);

        Button saveButton=(Button) view.findViewById(R.id.buttonSelect);
        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0){
                Calendar selectedTime=Calendar.getInstance();
                selectedTime.set(dp.getYear(),dp.getMonth(),dp.getDayOfMonth());
                saveItem(selectedTime);
            }
        });

        Button buttonSave =(Button) view.findViewById(R.id.buttonSelect);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                Calendar selectedTime=Calendar.getInstance();
                selectedTime.set(dp.getYear(),dp.getMonth(),dp.getDayOfMonth());

                saveItem(selectedTime);
            }
        });
        Button cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;
    }

    private void saveItem(Calendar selectedTime) {
        SaveDateListener activity = (SaveDateListener) getActivity();
        activity.didFinishDatePickerDialog(selectedTime);
        getDialog().dismiss();
    }

}
