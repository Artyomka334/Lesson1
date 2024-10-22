package ru.mirea.kachalov.domain.usecases;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class GetMushroomInfoUseCase {
    private final MushroomRepository mushroomRepository;

    public GetMushroomInfoUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public Mushroom execute(int id) {
        return mushroomRepository.getMushroomInfo(id);
    }
}