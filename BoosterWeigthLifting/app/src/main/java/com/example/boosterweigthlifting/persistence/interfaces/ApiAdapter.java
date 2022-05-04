package com.example.boosterweigthlifting.persistence.interfaces;

import com.example.boosterweigthlifting.persistence.models.MovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.PullMovimientoPrincipal;
import com.example.boosterweigthlifting.persistence.models.RmCleanJerk;
import com.example.boosterweigthlifting.persistence.models.RmSnatch;
import com.example.boosterweigthlifting.persistence.models.RmSquat;
import com.example.boosterweigthlifting.persistence.models.Squat;
import com.example.boosterweigthlifting.persistence.models.Usuario;
import com.example.boosterweigthlifting.persistence.models.VarMovimientoSecundario;
import com.example.boosterweigthlifting.persistence.models.Wod;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiAdapter {


    @GET("mov/principal")
    Call<ArrayList<MovimientoPrincipal>> getAllMovimientoPrincipal();

    @GET("mov/principal/{idWod}")
    Call<ArrayList<MovimientoPrincipal>> getMovimientoPrincipalByIdWod(@Path("idWod") int idWod);

    @GET("mov/pullprincipal")
    Call<ArrayList<PullMovimientoPrincipal>> getAllPullMovimientoPrincipal();

    @GET("mov/pullprincipal/{idWod}")
    Call<ArrayList<PullMovimientoPrincipal>> getPullMovimientoPrincipalByIdWod(@Path("idWod") int idWod);

    @GET("mov/varsecundario")
    Call<ArrayList<VarMovimientoSecundario>> getAllMovimientoSecundario();

    @GET("mov/varsecundario/{idWod}")
    Call<ArrayList<VarMovimientoSecundario>> getVarMovimientoSecundarioByIdWod(@Path("idWod") int idWod);

    @GET("mov/squat")
    Call<ArrayList<Squat>> getAllSquat();

    @GET("mov/squat/{idWod}")
    Call<ArrayList<Squat>> getSquatByIdWod(@Path("idWod") int idWod);

    @GET("wod")
    Call<ArrayList<Wod>> getAllWod();

    @GET("wod/{idUser}")
    Call<ArrayList<Wod>> getWodByIdUser(@Path("idUser") int user);

    @GET("usuario")
    Call<ArrayList<Usuario>> getUsuarioByEmailAndPass
            (@Query("email") String email, @Query("pass") String pass);

    @GET("usuario/{idUser}")
    Call<Usuario> getUsuarioById(@Path("idUser") int user);

    @GET("rm/squat")
    Call<ArrayList<RmSquat>> getAllRmSquat();

    @GET("rm/squat/{idWod}")
    Call<ArrayList<RmSquat>> getRmSquatByIdWod(@Path("idWod") int idWod);

    @GET("rm/snatch")
    Call<ArrayList<RmSnatch>> getAllRmSnatch();

    @GET("rm/snatch/{idWod}")
    Call<ArrayList<RmSnatch>> getRmSnatchByIdWod(@Path("idWod") int idWod);

    @GET("rm/cleanjerk")
    Call<ArrayList<RmCleanJerk>> getAllRmCleanJerk();

    @GET("rm/cleanjerk/{idWod}")
    Call<ArrayList<RmCleanJerk>> getRmCleanJerkByIdWod(@Path("idWod") int idWod);

    @POST("wod")
    Call<Wod> setWod(@Body Wod wod);

    @POST("wod")
    Call<ArrayList<Wod>> setAllWod(@Body ArrayList<Wod> wod);

    @POST("usuario")
    Call<Usuario> setUsuario(@Body Usuario usuario);





}
