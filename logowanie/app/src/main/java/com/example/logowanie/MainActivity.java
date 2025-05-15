package com.example.logowanie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL = "admin@example.com";
    private static final String CORRECT_PASSWORD = "secret123";

    private EditText emailInput;
    private EditText passwordInput;
    private TextView messageText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        messageText = findViewById(R.id.messageText);
        loginButton = findViewById(R.id.loginButton);

        messageText.setText("Autor: Paweł Sadowski");

        loginButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            String message;
            if (!email.contains("@")) {
                message = "Nieprawidłowy format loginu (e-mail).";
            } else if (!email.equals(CORRECT_EMAIL)) {
                message = "Brak użytkownika o podanym loginie.";
            } else if (!password.equals(CORRECT_PASSWORD)) {
                message = "Błędne hasło.";
            } else {
                message = "Zalogowano pomyślnie!";
            }

            messageText.setText(message);
        });
    }
}