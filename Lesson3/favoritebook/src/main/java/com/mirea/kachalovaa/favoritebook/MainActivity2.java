package com.mirea.kachalovaa.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editTextText);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            editText.setText(String.format(extras.getString(MainActivity.KEY)));
        }
    }

    public void sendData(View view) {
        String content = editText.getText().toString();

        if (content.length() < 1) {
            Intent data = new Intent();
            setResult(Activity.RESULT_CANCELED, data);
            finish();
        } else {
            Intent data = new Intent();
            data.putExtra(MainActivity.USER_MESSAGE, content);
            setResult(Activity.RESULT_OK, data);
            finish();
        }
    }
}