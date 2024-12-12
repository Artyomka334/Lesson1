package ru.mirea.kachalov.mushroomfinder.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kachalov.domain.models.Mushroom;
import ru.mirea.kachalov.mushroomfinder.R;
import ru.mirea.kachalov.mushroomfinder.presentation.recViews.MainMushroomsRecAdapter;
import ru.mirea.kachalov.mushroomfinder.presentation.viewModels.HomeFactoryViewModelFactory;
import ru.mirea.kachalov.mushroomfinder.presentation.viewModels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel viewModel;

    private RecyclerView mushroomsRecycler;
    private MainMushroomsRecAdapter mushroomsRecAdapter;
    private List<Mushroom> mushroomList;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mushroomsRecycler = view.findViewById(R.id.content);
        mushroomsRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        mushroomList = new ArrayList<>();
        mushroomsRecAdapter = new MainMushroomsRecAdapter(mushroomList);
        mushroomsRecycler.setAdapter(mushroomsRecAdapter);

        viewModel.getMushroomsLiveData().observe(getViewLifecycleOwner(), mushrooms -> {
            mushroomList.clear();
            mushroomList.addAll(mushrooms);

            mushroomsRecAdapter.notifyDataSetChanged();
        });

        viewModel.loadMushrooms();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this, new HomeFactoryViewModelFactory(requireContext()))
                .get(HomeFragmentViewModel.class);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}