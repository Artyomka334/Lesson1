package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class LoadAllMushroomsUseCase {
    private final MushroomRepository mushroomRepository;

    public LoadAllMushroomsUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom[] execute() {
        return mushroomRepository.loadAllMushrooms();
    }
}