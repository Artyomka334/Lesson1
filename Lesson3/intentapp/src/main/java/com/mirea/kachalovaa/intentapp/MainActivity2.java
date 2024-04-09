package com.mirea.kachalovaa.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String dateString = intent.getStringExtra("date");

        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String newString = DateTimeFormatter.ofPattern("HH:mm").format(dateTime);

        textView.setText(String.format(Locale.getDefault(), "КВАДРАТ ЗНАЧЕНИЯ " +
                "МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ %d, а текущее " +
                "время %s", (int) Math.pow(11, 2), newString));
    }

}