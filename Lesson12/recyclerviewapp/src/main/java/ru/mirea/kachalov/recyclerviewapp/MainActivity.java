package ru.mirea.kachalov.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Event> historicEvents = createEvents();
        recyclerView.setAdapter(new EventRecyclerAdapter(historicEvents));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<Event> createEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event("World War II",
                "A global war that lasted from 1939 to 1945, involving the Axis powers and the Allies.",
                "world_war_ii"));
        events.add(new Event("Cold War",
                "A period of geopolitical tension between the United States and the Soviet Union and their respective allies, from the late 1940s to the early 1990s.",
                "cold_war"));
        events.add(new Event("American Revolution",
                "The American Revolution was a colonial revolt that took place between 1765 and 1783.",
                "american_revolution"));
        events.add(new Event("Industrial Revolution",
                "The transition to new manufacturing processes in Europe and the United States, in the period from about 1760 to sometime between 1820 and 1840.",
                "industrial_revolution"));
        events.add(new Event("Russian Revolution",
                "A period of political and social revolution that took place in the former Russian Empire which began during the First World War.",
                "russian_revolution"));

        return events;
    }

}