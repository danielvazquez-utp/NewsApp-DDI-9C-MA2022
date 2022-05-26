package com.example.news;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

import com.example.news.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends Activity {

    private TextView nTextView;
    private Button nButton;
    private final List<String> mensajes = Arrays.asList(
            "Bienvenido a la vida",
            "¿Cómo va tu día?",
            "¿Qué hace?",
            "¡Listo para la acción!",
            "¡Al infinito y mas allá!"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nTextView = findViewById(R.id.newsTextView);
        nButton = findViewById(R.id.moreButton);
        Random aleatorio = new Random();
        String mensaje = mensajes.get(4);
        nTextView.setText(mensaje);
    }
}