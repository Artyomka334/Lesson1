package ru.mirea.kachalov.domain.usecases;

import java.util.List;

import ru.mirea.kachalov.domain.ApiCallback;
import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class LoadAllMushroomsUseCase {
    private final MushroomRepository mushroomRepository;

    public LoadAllMushroomsUseCase(MushroomRepository mushroomRepository) {
        this.mushroomRepository = mushroomRepository;
    }

    public void execute(ApiCallback<List<Mushroom>> apiCallback) {
        mushroomRepository.loadAllMushrooms(apiCallback);
    }
}