package com.example.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

import com.example.news.client.RetrofitClient;
import com.example.news.databinding.ActivityMainBinding;
import com.example.news.entity.Message;
import com.example.news.service.RetrofitApiService;

import java.util.Arrays;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        nTextView = findViewById(R.id.newsTextView);
        nButton = findViewById(R.id.moreButton);
        */

        /**
        String mensaje = mensajes.get(4);
        nTextView.setText(mensaje);
         */

        /**
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random aleatorio = new Random();
                // String mensaje = mensajes.get(4);
                String mensaje = mensajes.get(aleatorio.nextInt(mensajes.size()));
                nTextView.setText(mensaje);
            }
        });
         */

        initView();
        initValues();
        getMessage(49);
    }

    private void initView(){
        nTextView = findViewById(R.id.newsTextView);
        nButton = findViewById(R.id.moreButton);
    }

    private void initValues(){
        apiService = RetrofitClient.getApiService();
    }

    private void getMessage(int id){
        apiService.getMessageId(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                nTextView.setText(message.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                nTextView.setText(t.toString());
            }
        });
    }
}