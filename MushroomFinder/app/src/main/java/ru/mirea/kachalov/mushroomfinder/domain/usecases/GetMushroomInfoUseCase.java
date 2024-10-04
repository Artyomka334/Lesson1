package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.domain.repository.MushroomRepository;

public class GetMushroomInfoUseCase {
    private final MushroomRepository mushroomRepository;

    public GetMushroomInfoUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom execute(int id) {
        return mushroomRepository.getMushroomInfo(id);
    }
}