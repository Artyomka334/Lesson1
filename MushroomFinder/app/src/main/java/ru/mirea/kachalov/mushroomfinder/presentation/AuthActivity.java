package ru.mirea.kachalov.mushroomfinder.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.kachalov.data.firebase.AuthController;
import ru.mirea.kachalov.data.firebase.FirebaseAuthController;
import ru.mirea.kachalov.data.repository.AccountRepositoryImpl;
import ru.mirea.kachalov.domain.AuthorizationCallback;
import ru.mirea.kachalov.domain.usecases.authorization.LogInUseCase;
import ru.mirea.kachalov.domain.usecases.authorization.RegisterUseCase;
import ru.mirea.kachalov.mushroomfinder.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText emailEditText = findViewById(R.id.email);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        Button registerButton = findViewById(R.id.registerButton);

        FirebaseAuthController firebaseAuthController = new FirebaseAuthController();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(firebaseAuthController);
        LogInUseCase logInUseCase = new LogInUseCase(accountRepository);
        RegisterUseCase registerUseCase = new RegisterUseCase(accountRepository);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    return;
                } else {
                    logInUseCase.execute(email, password, new AuthorizationCallback() {
                        @Override
                        public void onSuccess() {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        @Override
                        public void onFailure() {
                            Toast.makeText(getApplicationContext(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    return;
                } else {
                    registerUseCase.execute(username, password, new AuthorizationCallback() {
                        @Override
                        public void onSuccess() {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        @Override
                        public void onFailure() {
                            Toast.makeText(getApplicationContext(), "Ошибка авторизации", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}