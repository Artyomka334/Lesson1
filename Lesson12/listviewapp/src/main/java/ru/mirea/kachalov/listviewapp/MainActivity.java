package ru.mirea.kachalov.listviewapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<String> titles = createBooks(30);
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, titles);
        listView.setAdapter(arrayAdapter);
    }

    private static List<String> createBooks(int numTitles) {
        List<String> titles = new ArrayList<>();
        String[] realTitles = {
                "The Kite Runner", "The Book Thief", "The Help",
                "The Hunger Games", "The Girl with the Dragon Tattoo", "The Girl on the Train",
                "The Silent Patient", "The Revenant", "The Martian",
                "The Handmaid's Tale", "The Road", "The Name of the Rose",
                "The God of Small Things", "The Remains of the Day", "The Poisonwood Bible",
                "The Color Purple", "Beloved", "The House of Mirth",
                "A Tree Grows in Brooklyn", "The Grapes of Wrath", "East of Eden",
                "The Sun Also Rises", "A Farewell to Arms", "For Whom the Bell Tolls",
                "Slaughterhouse-Five", "Catch-22", "The Things They Carried",
                "The Absolutely True Diary of a Part-Time Indian", "The Perks of Being a Wallflower",
                "The Fault in Our Stars"
        };

        Collections.shuffle(Arrays.asList(realTitles));
        titles.addAll(Arrays.asList(realTitles).subList(0, Math.min(numTitles, realTitles.length)));

        return titles;
    }

}