package ru.mirea.kachalov.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import ru.mirea.kachalov.data.room.models.Mushroom;

import java.util.List;

@Dao
public interface MushroomsDAO {

    @Query("select * from mushrooms")
    public List<Mushroom> getAllMushrooms();

    @Query("select * from mushrooms where title==:title")
    public List<Mushroom> getMushroomsByTitle(String title);

    @Insert
    public void addMushroom(Mushroom mushroom);

    @Update
    public void changeMushroom(Mushroom mushroom);

    @Query("delete from mushrooms where title==:title")
    public void removeMushrooms(String title);

    @Query("delete from mushrooms")
    public void clear();

}
