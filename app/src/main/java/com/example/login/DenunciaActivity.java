package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.ModelosDeClases.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DenunciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);
    }
    public void denunciarOnClick(View v){
        EditText editText = (EditText) findViewById(R.id.date);
        EditText editText2 = (EditText) findViewById(R.id.title);
        EditText editText3 = (EditText) findViewById(R.id.message);
        EditText editText4 = (EditText) findViewById(R.id.sender);
        String username = editText4.getText().toString();
        String date = editText.getText().toString();
        String title = editText2.getText().toString();
        String message = editText3.getText().toString();

        Denuncia denuncia = new Denuncia(date, title, message, username);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DenunciarService denunciar = retrofit.create(DenunciarService.class);

        Call<DenunciaRespuesta> call = denunciar.CreateDenuncia(denuncia);
        call.enqueue(new Callback<DenunciaRespuesta>() {

            @Override
            public void onResponse(Call<DenunciaRespuesta> call, Response<DenunciaRespuesta> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(DenunciaActivity.this, "Denuncia enviada correctamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (response.code() == 404) {
                        Toast.makeText(DenunciaActivity.this, "El usuario descrito como sender no existe", Toast.LENGTH_SHORT).show();
                    }
                    if(response.code() == 501){
                        Toast.makeText(DenunciaActivity.this, "Error, faltan datos en la denuncia", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<DenunciaRespuesta> call, Throwable t) {
                Toast.makeText(DenunciaActivity.this, "Error No response", Toast.LENGTH_SHORT).show();
            }
        });
    }
}