package com.mirea.kachalovaa.employeedb;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.mirea.kachalovaa.employeedb.App;
import com.mirea.kachalovaa.employeedb.AppDatabase;
import com.mirea.kachalovaa.employeedb.R;
import com.mirea.kachalovaa.employeedb.Superhero;
import com.mirea.kachalovaa.employeedb.SuperheroDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();

        SuperheroDao superheroDao = db.superheroDao();
        Superhero superhero = new Superhero();
        superhero.id = 1;
        superhero.nickname = "Runner";
        superhero.height = 150;
        superhero.weight = 80;
        superhero.ability = "Speed";
        superhero.age = 71;

        superheroDao.insert(superhero);

        List<Superhero> superheros = superheroDao.getAll();

        superhero = superheroDao.getById(1);

        superhero.height = 180;
        superheroDao.update(superhero);

        Log.d("DATABASE SIGNAL", superhero.nickname + " " + superhero.height + " " + superhero.weight + " " + superhero.ability + " " + superhero.age);

    }
}