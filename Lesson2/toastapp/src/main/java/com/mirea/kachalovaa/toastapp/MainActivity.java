package com.mirea.kachalovaa.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onCountClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                String.format(Locale.getDefault(),
                        "СТУДЕНТ № %d ГРУППА %s Количество символов - %d",
                        11, "БСБО-10-21", editText.getText().length()),
                Toast.LENGTH_SHORT);
        toast.show();
    }
}