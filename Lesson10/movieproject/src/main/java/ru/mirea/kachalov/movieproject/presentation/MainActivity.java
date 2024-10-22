package ru.mirea.kachalov.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.kachalov.data.data.MovieRepositoryImpl;
import ru.mirea.kachalov.data.data.storage.MovieStorage;
import ru.mirea.kachalov.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.kachalov.domain.domain.repository.MovieRepository;
import ru.mirea.kachalov.movieproject.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);
        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new
                        ru.mirea.kachalov.domain.domain.usecases.SaveMovieToFavoriteUseCase(movieRepository).execute(new ru.mirea.kachalov.domain.domain.models.Movie(2,
                        text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ru.mirea.kachalov.domain.domain.models.Movie moview = new ru.mirea.kachalov.domain.domain.usecases.GetFavoriteFilmUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", moview.getName()));
            }
        });
    }
}