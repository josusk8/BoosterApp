package com.example.boosterweigthlifting.persistence.interfaces;

import com.example.boosterweigthlifting.persistence.models.MovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.Wod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiAdapter {

    @GET("principal")
    Call<List<MovimientoPrincipal>> getAllMovimientoPrincipal();

    @GET("wod")
    Call<List<Wod>> getAllWod();

}
