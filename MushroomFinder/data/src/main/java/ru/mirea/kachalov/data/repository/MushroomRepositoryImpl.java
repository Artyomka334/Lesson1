package ru.mirea.kachalov.data.repository;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class MushroomRepositoryImpl implements MushroomRepository {

    @Override
    public Mushroom identifyMushroom(String imagePath) {
        return new Mushroom(1, "Boletus", true);
    }

    @Override
    public Mushroom[] loadAllMushrooms() {
        return new Mushroom[]{
                new Mushroom(1, "Boletus", true),
                new Mushroom(2, "Amanita", false)
        };
    }

    @Override
    public Mushroom getMushroomInfo(int id) {
        return new Mushroom(id, "Test Mushroom", true);
    }
}
