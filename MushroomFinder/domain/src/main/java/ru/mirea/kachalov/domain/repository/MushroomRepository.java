package ru.mirea.kachalov.domain.repository;

import java.util.List;

import ru.mirea.kachalov.domain.ApiCallback;
import ru.mirea.kachalov.domain.models.Mushroom;

public interface MushroomRepository {
    Mushroom identifyMushroom(String imagePath);

    void loadAllMushrooms(ApiCallback<List<Mushroom>> apiCallback);

    Mushroom getMushroomInfo(int id);
}