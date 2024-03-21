package com.mirea.kachalovaa.controllesson2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callTimePicker(View view) {
        TimeDialogFragment fragment = new TimeDialogFragment(this, (timePicker, hours, minutes) -> {
            Log.d("TAG", String.format("Chosen: %d:%d", hours, minutes));
        }, 15, 30, true);
        fragment.show();

        initSnackbar(view, "Time picker already activated");
    }

    public void callDatePicker(View view) {
        DateDialogFragment fragment = new DateDialogFragment(this, (datePicker, year, month, day) -> {
            Log.d("TAG", String.format("Chosen: %d/%d/%d", year, month+1, day));
        }, 2024, 9, 3);
        fragment.show();

        initSnackbar(view, "Date picker already activated");
    }

    public void callProgressDialog(View view) {
        ProgressDialogFragment fragment = new ProgressDialogFragment(this);
        fragment.setTitle("Kachalov Artyom");
        fragment.setMessage("Stand by");
        fragment.show();

        initSnackbar(view, "Progress dialog already activated");
    }

    private void initSnackbar(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_LONG)
                .show();
    }
}