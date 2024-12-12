package ru.mirea.kachalov.mushroomfinder.presentation.viewModels;

import android.content.Context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.kachalov.data.api.DataSource;
import ru.mirea.kachalov.data.repository.MushroomRepositoryImpl;
import ru.mirea.kachalov.domain.ApiCallback;
import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.domain.usecases.LoadAllMushroomsUseCase;

public class HomeFragmentViewModel extends ViewModel {

    private LoadAllMushroomsUseCase loadAllMushroomsUseCase;

    private DataSource dataSource;

    private MutableLiveData<List<Mushroom>> mushrooms = new MutableLiveData<>();
    private MediatorLiveData<List<Mushroom>> mushroomsLiveData = new MediatorLiveData<>();

    private final Context context;

    public HomeFragmentViewModel(Context context) {
        this.context = context;

        dataSource = new DataSource();
        MushroomRepositoryImpl mushroomRepository = new MushroomRepositoryImpl(dataSource);

        loadAllMushroomsUseCase = new LoadAllMushroomsUseCase(mushroomRepository);

        mushroomsLiveData.addSource(mushrooms, mushrooms -> {
            getMushroomsLiveDataR(mushrooms);
        });
    }

    private void getMushroomsLiveDataR(List<Mushroom> mushrooms) {
        mushroomsLiveData.setValue(mushrooms);
    }

    public void loadMushrooms() {
        loadAllMushroomsUseCase.execute(new ApiCallback<List<Mushroom>>() {
            @Override
            public void onSuccess(List<Mushroom> result) {
                mushrooms.setValue(result);
            }

            @Override
            public void onError(Exception e) {
                System.out.println("Error: " + e.toString());
            }
        });
    }

    public MediatorLiveData<List<Mushroom>> getMushroomsLiveData() {
        return mushroomsLiveData;
    }

}
