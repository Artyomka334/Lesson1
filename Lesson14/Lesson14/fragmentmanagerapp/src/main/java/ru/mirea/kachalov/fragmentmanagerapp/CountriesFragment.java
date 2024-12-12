package ru.mirea.kachalov.fragmentmanagerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public CountriesFragment() {

    }

    public static CountriesFragment newInstance(String param1) {
        CountriesFragment fragment = new CountriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    private ListView list;
    private Map<String, String> data;

    private ShareViewModel viewModel;

    public static Map<String, String> getCountries() {
        Map<String, String> countryMap = new HashMap<>();

        countryMap.put("Germany", "A central European country known for its engineering, history, and beer.");
        countryMap.put("United Kingdom", "An island nation in Europe consisting of England, Scotland, Wales, and Northern Ireland.");
        countryMap.put("China", "The most populous country in the world, located in East Asia with a rich history and diverse culture.");
        countryMap.put("India", "A country in South Asia known for its ancient civilization, vibrant traditions, and Bollywood films.");
        countryMap.put("Australia", "An island continent in the Southern Hemisphere known for its unique wildlife and stunning natural beauty.");
        countryMap.put("Italy", "A European country famous for its art, history, fashion, and delicious food.");
        countryMap.put("Mexico", "A country in North America known for its ancient civilizations, vibrant culture, and spicy cuisine.");
        countryMap.put("Russia", "The largest country in the world, spanning Eastern Europe and Northern Asia.");
        countryMap.put("South Africa", "A country located at the southern tip of Africa, known for its diverse wildlife and vibrant culture.");
        countryMap.put("Spain", "A European country famous for its art, architecture, flamenco music, and tapas.");

        return countryMap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        list = view.findViewById(R.id.countries);

        data = getCountries();
        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        List<String> countryNames = new ArrayList<>(data.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, countryNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedCountry = countryNames.get(position);
            viewModel.setSomeValue(data.get(selectedCountry));
        });
        return view;
    }
}