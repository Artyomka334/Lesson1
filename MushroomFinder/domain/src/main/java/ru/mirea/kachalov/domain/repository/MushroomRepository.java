package ru.mirea.kachalov.domain.repository;

import ru.mirea.kachalov.domain.models.Mushroom;

public interface MushroomRepository {
    Mushroom identifyMushroom(String imagePath);

    Mushroom[] loadAllMushrooms();

    Mushroom getMushroomInfo(int id);
}