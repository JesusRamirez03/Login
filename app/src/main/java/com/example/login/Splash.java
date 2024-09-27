package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    private TextView splashLabel;
    private int secondsRemaining = 5; // Tiempo en segundos para el splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        splashLabel = findViewById(R.id.splash_label);

        // Actualiza el label cada segundo
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (secondsRemaining > 0) {
                    splashLabel.setText("Cambiando en " + secondsRemaining + " segundos...");
                    secondsRemaining--;
                    handler.postDelayed(this, 1000); // Llamar de nuevo después de 1 segundo
                } else {
                    // Después de 5 segundos, cambiar a MainActivity
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        // Ejecuta la cuenta regresiva inmediatamente
        handler.post(runnable);
    }
}