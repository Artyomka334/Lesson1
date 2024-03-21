package com.mirea.kachalovaa.controllesson2;

import android.app.DatePickerDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DateDialogFragment extends DatePickerDialog {
    public DateDialogFragment(@NonNull Context context) {
        super(context);
    }

    public DateDialogFragment(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public DateDialogFragment(@NonNull Context context, @Nullable OnDateSetListener listener, int year, int month, int dayOfMonth) {
        super(context, listener, year, month, dayOfMonth);
    }

    public DateDialogFragment(@NonNull Context context, int themeResId, @Nullable OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context, themeResId, listener, year, monthOfYear, dayOfMonth);
    }
}
