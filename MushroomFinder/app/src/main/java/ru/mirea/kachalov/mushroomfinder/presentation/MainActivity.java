package ru.mirea.kachalov.mushroomfinder.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kachalov.mushroomfinder.R;
import ru.mirea.kachalov.mushroomfinder.data.repository.AccountRepositoryImpl;
import ru.mirea.kachalov.mushroomfinder.domain.usecases.LogInUseCase;
import ru.mirea.kachalov.mushroomfinder.domain.usecases.RegisterUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        LogInUseCase logInUseCase = new LogInUseCase(accountRepository);
        RegisterUseCase registerUseCase = new RegisterUseCase(accountRepository);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    resultTextView.setText("Введите имя пользователя и пароль!");
                } else {
                    boolean success = logInUseCase.execute(username, password);
                    resultTextView.setText(success ? "Вход выполнен успешно!" : "Ошибка входа: неверные учетные данные");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    resultTextView.setText("Введите имя пользователя и пароль!");
                } else {
                    boolean success = registerUseCase.execute(username, password);
                    resultTextView.setText(success ? "Регистрация выполнена успешно!" : "Ошибка регистрации");
                }
            }
        });
    }
}