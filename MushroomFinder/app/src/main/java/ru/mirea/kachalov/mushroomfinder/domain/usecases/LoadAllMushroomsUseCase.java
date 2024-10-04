package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.domain.repository.MushroomRepository;

public class LoadAllMushroomsUseCase {
    private final MushroomRepository mushroomRepository;

    public LoadAllMushroomsUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom[] execute() {
        return mushroomRepository.loadAllMushrooms();
    }
}