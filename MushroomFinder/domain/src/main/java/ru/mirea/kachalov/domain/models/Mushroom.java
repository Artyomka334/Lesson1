package ru.mirea.kachalov.domain.models;

public class Mushroom {
    private int id;
    private String name;
    private boolean edible;

    public Mushroom(int id, String name, boolean edible) {
        this.id = id;
        this.name = name;
        this.edible = edible;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEdible() {
        return edible;
    }

    @Override
    public String toString() {
        return "Mushroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}