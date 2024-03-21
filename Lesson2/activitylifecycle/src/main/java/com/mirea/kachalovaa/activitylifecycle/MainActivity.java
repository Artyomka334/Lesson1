package com.mirea.kachalovaa.activitylifecycle;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    /*
    Вопросы:
        1. Будет ли вызван метод «onCreate» после нажатия на кнопку «Home» и возврата
        в приложение? Ответ: Нет
        2. Изменится ли значение поля «EditText» после нажатия на кнопку «Home» и
        возврата в приложение? Ответ: Нет
        3. Изменится ли значение поля «EditText» после нажатия на кнопку «Back» и
        возврата в приложение? Ответ: Нет
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("CREATE TAG", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("START TAG", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}