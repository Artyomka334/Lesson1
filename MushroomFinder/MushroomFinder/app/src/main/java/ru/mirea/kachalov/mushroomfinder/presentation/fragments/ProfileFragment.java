package ru.mirea.kachalov.mushroomfinder.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

import ru.mirea.kachalov.domain.UserCallback;
import ru.mirea.kachalov.domain.models.Account;
import ru.mirea.kachalov.mushroomfinder.R;
import ru.mirea.kachalov.mushroomfinder.presentation.recViews.ProfileFragmentViewModel;

public class ProfileFragment extends Fragment {

    private ProfileFragmentViewModel viewModel;

    private TextView emailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ProfileFragmentViewModel.class);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Account>() {
            @Override
            public void onChanged(Account account) {
                emailTextView.setText(account.getEmail());
            }
        });

        setupInfo(view);
    }

    private void setupInfo(View view) {
        emailTextView = view.findViewById(R.id.emailText);

        viewModel.getUserInfo(new UserCallback() {
            @Override
            public void onSuccess(Account account) {
                viewModel.setMutableLiveData(account);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}