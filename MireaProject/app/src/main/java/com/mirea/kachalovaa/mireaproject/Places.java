package com.mirea.kachalovaa.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.osmdroid.util.GeoPoint;

public class Places extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Places() {
        // Required empty public constructor
    }

    public static Places newInstance(String param1, String param2) {
        Places fragment = new Places();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button homeButton = view.findViewById(R.id.homeButton);
        Button universityButton = view.findViewById(R.id.univButton);

        universityButton.setOnClickListener(view1 -> getPointInfo(
                new GeoPoint(55.670005, 37.479894),
                "Университет",
                "Проспект вернадского, 78",
                "Главный корпус университета")
        );

        homeButton.setOnClickListener(view1 -> getPointInfo(
                new GeoPoint(55.6446, 37.7242),
                "Дом",
                "Батайский проезд, 29",
                "Домик, где я живу")
        );
    }

    private void getPointInfo(GeoPoint point, String title, String address, String description) {
        Intent intent = new Intent(getContext(), MapActivity.class);
        intent.putExtra("lat", point.getLatitude());
        intent.putExtra("long", point.getLongitude());

        intent.putExtra("title", title);
        intent.putExtra("address", address);
        intent.putExtra("desc", description);

        getContext().startActivity(intent);
    }
}