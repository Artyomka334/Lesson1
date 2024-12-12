package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.FavouritesRepository;

public class GetFavoritesUseCase {
    private final FavouritesRepository favouritesRepository;

    public GetFavoritesUseCase(FavouritesRepository favouritesRepository) {
        this.favouritesRepository = favouritesRepository;
    }

    public Mushroom[] execute() {
        return favouritesRepository.getFavourites();
    }
}