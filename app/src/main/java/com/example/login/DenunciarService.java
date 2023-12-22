package com.example.login;

import com.example.login.ModelosDeClases.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DenunciarService {
    @Headers("Content-Type:application/json")
    @POST("dsaApp/jugadores/issue")
    Call<DenunciaRespuesta> CreateDenuncia(@Body Denuncia denuncia);
}
