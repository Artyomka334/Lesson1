package com.mirea.kachalovaa.controllesson2;

import android.app.TimePickerDialog;
import android.content.Context;

public class TimeDialogFragment extends TimePickerDialog {
    public TimeDialogFragment(Context context,
                              OnTimeSetListener listener,
                              int hourOfDay,
                              int minute,
                              boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }

    public TimeDialogFragment(Context context,
                              int themeResId,
                              OnTimeSetListener listener,
                              int hourOfDay,
                              int minute,
                              boolean is24HourView) {
        super(context, themeResId, listener, hourOfDay, minute, is24HourView);
    }
}
