package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.domain.repository.MushroomRepository;

public class IdentifyMushroomUseCase {
    private final MushroomRepository mushroomRepository;

    public IdentifyMushroomUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom execute(String imagePath) {
        return mushroomRepository.identifyMushroom(imagePath);
    }
}
