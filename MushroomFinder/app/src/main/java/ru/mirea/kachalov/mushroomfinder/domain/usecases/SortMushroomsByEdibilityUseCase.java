package ru.mirea.kachalov.mushroomfinder.domain.usecases;

import ru.mirea.kachalov.mushroomfinder.domain.models.Mushroom;

import java.util.Arrays;
import java.util.Comparator;

public class SortMushroomsByEdibilityUseCase {

    public Mushroom[] execute(Mushroom[] mushrooms) {
        Arrays.sort(mushrooms, Comparator.comparing(Mushroom::isEdible).reversed());
        return mushrooms;
    }
}