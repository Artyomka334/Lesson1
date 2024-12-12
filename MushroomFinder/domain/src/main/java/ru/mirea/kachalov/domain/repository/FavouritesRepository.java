package ru.mirea.kachalov.domain.repository;

import ru.mirea.kachalov.domain.models.Mushroom;

public interface FavouritesRepository {
    boolean addToFavourites(Mushroom mushroom);

    boolean removeFromFavourites(int mushroomId);

    Mushroom[] getFavourites();
}