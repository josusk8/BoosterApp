package com.example.boosterweigthlifting.persistence.interfaces;

import com.example.boosterweigthlifting.persistence.models.MovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.PullMovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.Squat;
import com.example.boosterweigthlifting.persistence.models.Wod;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiAdapter {


    @GET("mov/principal")
    Call<ArrayList<MovimientoPrincipal>> getAllMovimientoPrincipal();

    @GET("mov/principal/{idWod}")
    Call<ArrayList<MovimientoPrincipal>> getMovimientoPrincipalByIdWod(@Path("idWod") int idWod);

    @GET("mov/pullprincipal")
    Call<ArrayList<PullMovimientoPrincipal>> getAllPullMovimientoPrincipal();

    @GET("mov/pullprincipal/{idWod}")
    Call<ArrayList<PullMovimientoPrincipal>> getPullMovimientoPrincipalByIdWod(@Path("idWod") int idWod);

    @GET("mov/squat")
    Call<ArrayList<Squat>> getAllSquat();

    @GET("mov/squat/{idWod}")
    Call<ArrayList<Squat>> getSquatByIdWod(@Path("idWod") int idWod);

    @GET("wod")
    Call<ArrayList<Wod>> getAllWod();

    @GET("wod/{idUser}")
    Call<ArrayList<Wod>> getByIdUser(@Path("idUser") int user);

}
