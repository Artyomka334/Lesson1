package ru.mirea.kachalov.data.data.storage;

import ru.mirea.kachalov.data.data.storage.models.Movie;

public interface MovieStorage {
    Movie get();
    boolean save(Movie movie);
}
