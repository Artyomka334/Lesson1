package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.domain.repository.FavouritesRepository;

public class GetFavoritesUseCase {
    private final FavouritesRepository favouritesRepository;

    public GetFavoritesUseCase(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public Mushroom[] execute() {
        return favouritesRepository.getFavourites();
    }
}