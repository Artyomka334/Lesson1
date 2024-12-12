package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.FavouritesRepository;

public class AddToFavoritesUseCase {
    private final FavouritesRepository favouritesRepository;

    public AddToFavoritesUseCase(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public boolean execute(Mushroom mushroom) {
        return favouritesRepository.addToFavourites(mushroom);
    }
}