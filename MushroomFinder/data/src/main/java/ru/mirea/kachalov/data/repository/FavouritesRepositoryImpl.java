package ru.mirea.kachalov.data.repository;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.FavouritesRepository;

public class FavouritesRepositoryImpl implements FavouritesRepository {

    @Override
    public boolean addToFavourites(Mushroom mushroom) {
        return true;
    }

    @Override
    public boolean removeFromFavourites(int mushroomId) {
        return true;
    }

    @Override
    public Mushroom[] getFavourites() {
        return new Mushroom[]{
                new Mushroom(1, "Boletus", true)
        };
    }
}