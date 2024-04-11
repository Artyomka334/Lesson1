package com.mirea.kachalovaa.thread;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mirea.kachalovaa.thread.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private  int  counter  = 0;

    @Override
    protected  void  onCreate(Bundle  savedInstanceState)  {
        super.onCreate(savedInstanceState);
        binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());

        // Меняем имя и выводим в текстовом поле
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 10, НОМЕР ПО СПИСКУ: 11, МОЙ ЛЮБИМЫЙ ФИЛЬМ: Джанго Освобожденный");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(),  "Stack:  "  +  Arrays.toString(mainThread.getStackTrace()));

        binding.button.setOnClickListener(new  View.OnClickListener()  {
            @Override
            public  void onClick(View v)  {
                new  Thread(new  Runnable()  {
                    public  void run()  {
                        if (binding.editTextDays.getText().toString().length() < 1 || binding.editTextLessons.getText().toString().length() < 1)
                            return;

                        int days = Integer.parseInt(binding.editTextDays.getText().toString());
                        int lessons = Integer.parseInt(binding.editTextLessons.getText().toString());

                        runOnUiThread(() -> {binding.textView.setText(String.format("Среднее кол-во пар: %s", ((float) lessons / (float) days)));});
                    }
                }).start();
            }
        });
    }
}