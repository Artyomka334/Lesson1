package ru.mirea.kachalov.data.api;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.kachalov.domain.ApiCallback;
import ru.mirea.kachalov.domain.models.Mushroom;

public class DataSource {

    private static final String BASE_URL = "https://toxicshrooms.vercel.app/api/";
    private final MushroomApi mushroomApi;

    public DataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mushroomApi = retrofit.create(MushroomApi.class);
    }

    public void getMushrooms(ApiCallback<List<Mushroom>> apiCallback) {
        mushroomApi.getMushrooms().enqueue(new Callback<List<Mushroom>>() {
            @Override
            public void onResponse(Call<List<Mushroom>> call, Response<List<Mushroom>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    apiCallback.onSuccess(response.body());
                } else {
                    apiCallback.onError(new Exception("Error data source"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Mushroom>> call, @NonNull Throwable t) {
                System.out.println(t.toString());
                apiCallback.onError((Exception) t);
            }
        });
    }

}
