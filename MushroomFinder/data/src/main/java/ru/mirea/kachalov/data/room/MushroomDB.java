package ru.mirea.kachalov.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.kachalov.data.room.models.Mushroom;

@Database(entities = {Mushroom.class}, version = 1)
public abstract class MushroomDB extends RoomDatabase {

    public abstract MushroomsDAO getMushroomsDAO();

}
