package ru.mirea.kachalov.data.room;

import ru.mirea.kachalov.data.room.models.Mushroom;

public interface MushroomsDBController {

    public void getMushrooms();
    public void addMushroom(Mushroom mushroom);
    public void removeMushroom(String title);

}
