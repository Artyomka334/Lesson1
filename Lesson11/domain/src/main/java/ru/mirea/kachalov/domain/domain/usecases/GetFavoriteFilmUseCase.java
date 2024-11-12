package ru.mirea.kachalov.domain.domain.usecases;

import ru.mirea.kachalov.domain.domain.models.Movie;
import ru.mirea.kachalov.domain.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private final MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute() {
        return movieRepository.getMovie();
    }
}
