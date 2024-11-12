package ru.mirea.kachalov.movieproject.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.kachalov.domain.domain.models.Movie;
import ru.mirea.kachalov.domain.domain.repository.MovieRepository;
import ru.mirea.kachalov.domain.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.kachalov.domain.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivityViewModel extends ViewModel {

    private MovieRepository movieRepository;

    private MutableLiveData<String> favoriteMovie = new MutableLiveData<>();

    public MutableLiveData<String> getFavoriteMovie() {
        return favoriteMovie;
    }

    public MainActivityViewModel(MovieRepository movieRepository) {
        Log.d(MainActivityViewModel.class.getSimpleName().toString(), "MainViewModel created");
        this.movieRepository = movieRepository;
    }

    @Override
    protected void onCleared() {
        Log.d(MainActivityViewModel.class.getSimpleName().toString(), "MainViewModel cleared");
        super.onCleared();
    }

    public boolean setText(Movie movie){
        Boolean result = new SaveMovieToFavoriteUseCase(movieRepository).execute(movie);

        favoriteMovie.setValue(result.toString());
        return result;
    }
    public Movie getText(){
        Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();

        favoriteMovie.setValue(movie.getName());
        return movie;
    }

}
