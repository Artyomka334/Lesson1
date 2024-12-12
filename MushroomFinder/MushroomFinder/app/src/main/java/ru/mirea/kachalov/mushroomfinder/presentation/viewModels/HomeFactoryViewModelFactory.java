package ru.mirea.kachalov.mushroomfinder.presentation.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeFactoryViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public HomeFactoryViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeFragmentViewModel(context);
    }

}

