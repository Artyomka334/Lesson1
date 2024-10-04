package ru.mirea.kachalov.mushroomfinder.domain.repository;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;

public interface MushroomRepository {
    Mushroom identifyMushroom(String imagePath);

    Mushroom[] loadAllMushrooms();

    Mushroom getMushroomInfo(int id);
}