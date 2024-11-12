package ru.mirea.kachalov.domain.domain.repository;

import ru.mirea.kachalov.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}