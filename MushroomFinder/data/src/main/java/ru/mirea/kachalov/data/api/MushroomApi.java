package ru.mirea.kachalov.data.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mirea.kachalov.domain.models.Mushroom;

public interface MushroomApi {

    @GET("mushrooms")
    Call<List<Mushroom>> getMushrooms();

}
