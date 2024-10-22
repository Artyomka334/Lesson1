package ru.mirea.kachalov.mushroomfinder.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kachalov.mushroomfinder.R;
import ru.mirea.kachalov.data.repository.AccountRepositoryImpl;
import ru.mirea.kachalov.domain.usecases.authorization.LogInUseCase;
import ru.mirea.kachalov.domain.usecases.authorization.RegisterUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}