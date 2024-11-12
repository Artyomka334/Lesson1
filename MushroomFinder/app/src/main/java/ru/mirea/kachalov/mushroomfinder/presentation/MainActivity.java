package ru.mirea.kachalov.mushroomfinder.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.R;
import ru.mirea.kachalov.data.repository.AccountRepositoryImpl;
import ru.mirea.kachalov.domain.usecases.authorization.LogInUseCase;
import ru.mirea.kachalov.domain.usecases.authorization.RegisterUseCase;
import ru.mirea.kachalov.mushroomfinder.presentation.recViews.MainMushroomsRecAdapter;
import ru.mirea.kachalov.mushroomfinder.presentation.viewModels.MainActivityViewModel;
import ru.mirea.kachalov.mushroomfinder.presentation.viewModels.MainActivityViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    private RecyclerView mushroomsRecycler;
    private MainMushroomsRecAdapter mushroomsRecAdapter;
    private List<Mushroom> mushroomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new MainActivityViewModelFactory(this))
                .get(MainActivityViewModel.class);

        mushroomsRecycler = findViewById(R.id.content);
        mushroomsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mushroomList = new ArrayList<>();
        mushroomsRecAdapter = new MainMushroomsRecAdapter(mushroomList);
        mushroomsRecycler.setAdapter(mushroomsRecAdapter);

        viewModel.getMushroomsLiveData().observe(this, mushrooms -> {
            mushroomList.clear();
            mushroomList.addAll(mushrooms);

            mushroomsRecAdapter.notifyDataSetChanged();
        });

        viewModel.loadMushrooms();
    }

}