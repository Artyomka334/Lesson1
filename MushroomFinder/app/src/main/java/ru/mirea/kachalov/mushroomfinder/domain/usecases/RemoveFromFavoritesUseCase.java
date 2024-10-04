package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.repository.FavouritesRepository;

public class RemoveFromFavoritesUseCase {
    private final FavouritesRepository favouritesRepository;

    public RemoveFromFavoritesUseCase(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public boolean execute(int mushroomId) {
        return favouritesRepository.removeFromFavourites(mushroomId);
    }
}