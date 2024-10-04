package ru.mirea.kachalov.mushroomfinder.domain.repository;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;

public interface FavouritesRepository {
    boolean addToFavourites(Mushroom mushroom);

    boolean removeFromFavourites(int mushroomId);

    Mushroom[] getFavourites();
}