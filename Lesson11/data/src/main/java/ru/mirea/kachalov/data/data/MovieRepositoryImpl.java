package ru.mirea.kachalov.data.data;

import java.time.LocalDate;

import ru.mirea.kachalov.data.data.storage.MovieStorage;
import ru.mirea.kachalov.data.data.storage.models.Movie;
import ru.mirea.kachalov.domain.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(ru.mirea.kachalov.domain.domain.models.Movie movie) {
        return movieStorage.save(mapToStorage(movie));
    }

    @Override
    public ru.mirea.kachalov.domain.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(ru.mirea.kachalov.domain.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.kachalov.domain.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.kachalov.domain.domain.models.Movie(movie.getId(), movie.getName());
    }

}
