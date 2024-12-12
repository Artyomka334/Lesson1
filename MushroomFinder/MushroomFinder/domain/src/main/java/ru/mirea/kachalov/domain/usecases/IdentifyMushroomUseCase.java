package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class IdentifyMushroomUseCase {
    private final MushroomRepository mushroomRepository;

    public IdentifyMushroomUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom execute(String imagePath) {
        return mushroomRepository.identifyMushroom(imagePath);
    }
}
