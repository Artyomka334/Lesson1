package ru.mirea.kachalov.data.room;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.kachalov.data.room.models.Mushroom;

public class RoomMushroomsDBController implements MushroomsDBController {

    private MushroomDB mushroomDB;
    private Context context;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RoomMushroomsDBController(Context context) {
        this.context = context;

        mushroomDB = Room.databaseBuilder(context, MushroomDB.class, "MushroomsDB")
                .build();
    }

    @Override
    public void getMushrooms() {
        executorService.execute(() -> mushroomDB.getMushroomsDAO().getAllMushrooms());
    }

    @Override
    public void addMushroom(Mushroom mushroom) {
        executorService.execute(() -> mushroomDB.getMushroomsDAO().addMushroom(mushroom));
    }

    @Override
    public void removeMushroom(String title) {
        executorService.execute(() -> mushroomDB.getMushroomsDAO().removeMushrooms(title));
    }

}
