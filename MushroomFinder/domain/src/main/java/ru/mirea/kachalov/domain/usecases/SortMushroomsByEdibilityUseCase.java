package ru.mirea.kachalov.domain.usecases;

import java.util.Arrays;
import java.util.Comparator;

import ru.mirea.kachalov.domain.models.Mushroom;

public class SortMushroomsByEdibilityUseCase {

    public Mushroom[] execute(Mushroom[] mushrooms) {
        Arrays.sort(mushrooms, Comparator.comparing(Mushroom::isEdible).reversed());
        return mushrooms;
    }
}