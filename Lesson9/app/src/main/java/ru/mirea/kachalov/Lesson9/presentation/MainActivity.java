package ru.mirea.kachalov.Lesson9.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.kachalov.Lesson9.R;
import ru.mirea.kachalov.Lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.kachalov.Lesson9.domain.models.Movie;
import ru.mirea.kachalov.Lesson9.domain.repository.MovieRepository;
import ru.mirea.kachalov.Lesson9.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.kachalov.Lesson9.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(this);

        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new Movie(2, text.getText().toString());
                boolean result = new SaveMovieToFavoriteUseCase(movieRepository).execute(movie);
                textView.setText(String.format("Save result: %s", result));
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
                if (movie != null) {
                    textView.setText(String.format("Favorite movie: %s", movie.getName()));
                } else {
                    textView.setText("No favorite movie saved.");
                }
            }
        });
    }
}