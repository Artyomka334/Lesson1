package ru.mirea.kachalov.Lesson9.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.kachalov.Lesson9.domain.models.Movie;
import ru.mirea.kachalov.Lesson9.domain.repository.MovieRepository;
import ru.mirea.kachalov.Lesson9.presentation.MainActivity;

public class MovieRepositoryImpl implements MovieRepository {
    private static final String PREFS_NAME = "movie_prefs";
    private static final String MOVIE_ID_KEY = "movie_id";
    private static final String MOVIE_NAME_KEY = "movie_name";

    private final SharedPreferences sharedPreferences;

    public MovieRepositoryImpl(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MOVIE_ID_KEY, movie.getId());
        editor.putString(MOVIE_NAME_KEY, movie.getName());
        return editor.commit();
    }

    @Override
    public Movie getMovie() {
        int id = sharedPreferences.getInt(MOVIE_ID_KEY, -1);
        String name = sharedPreferences.getString(MOVIE_NAME_KEY, "");
        if (id != -1 && !name.isEmpty()) {
            return new Movie(id, name);
        } else {
            return null;
        }
    }
}
