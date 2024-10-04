package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.domain.repository.FavouritesRepository;

public class AddToFavoritesUseCase {
    private final FavouritesRepository favouritesRepository;

    public AddToFavoritesUseCase(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public boolean execute(Mushroom mushroom) {
        return favouritesRepository.addToFavourites(mushroom);
    }
}