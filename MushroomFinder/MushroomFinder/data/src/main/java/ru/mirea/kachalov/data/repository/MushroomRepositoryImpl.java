package ru.mirea.kachalov.data.repository;

import java.util.List;

import ru.mirea.kachalov.data.api.DataSource;
import ru.mirea.kachalov.domain.ApiCallback;
import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.repository.MushroomRepository;

public class MushroomRepositoryImpl implements MushroomRepository {

    private DataSource dataSource;

    public MushroomRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Mushroom identifyMushroom(String imagePath) {
        return new Mushroom();
    }

    @Override
    public void loadAllMushrooms(ApiCallback<List<Mushroom>> apiCallback) {
        dataSource.getMushrooms(apiCallback);
    }

    @Override
    public Mushroom getMushroomInfo(int id) {
        return new Mushroom();
    }
}
