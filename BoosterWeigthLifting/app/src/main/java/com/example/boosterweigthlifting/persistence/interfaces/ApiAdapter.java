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
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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

    @GET("rm/squat/{idUser}")
    Call<ArrayList<RmSquat>> getRmSquatByIdUser(@Path("idUser") int idUser);

    @GET("rm/snatch")
    Call<ArrayList<RmSnatch>> getAllRmSnatch();

    @GET("rm/snatch/{idUser}")
    Call<ArrayList<RmSnatch>> getRmSnatchByIdUser(@Path("idUser") int idUser);

    @GET("rm/cleanjerk")
    Call<ArrayList<RmCleanJerk>> getAllRmCleanJerk();

    @GET("rm/cleanjerk/{idUser}")
    Call<ArrayList<RmCleanJerk>> getRmCleanJerkByIdUser(@Path("idUser") int idUser);


    @FormUrlEncoded
    @Headers("Content-Type:application/json")
    @POST("wod")
    Call<Wod> setWod(@Body String rawJsonString);

    @FormUrlEncoded
    @Headers("Content-Type:application/json")
    @POST("wod")
    Call<ArrayList<Wod>> setAllWod(@Body ArrayList<Wod> wod);

    @FormUrlEncoded
    @Headers("Content-Type:application/json")
    @POST("wod")
    Call<ArrayList<Wod>> setAllWodString(@Body String rawJsonString);


    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("usuario")
    Call<Usuario> setUsuario (@Body Usuario usuario);;


    @Headers("Content-Type: application/json")
    @POST("usuario")
    Call<Usuario> setUserString(@Body String rawJsonString);



    //@HTTP(method = "DELETE", path = "rm/squat//7")
    @DELETE("rm/squat/{idUser}/{idSquat}")
    Call<Void> deleteSquat(@Path("idUser") int idUser, @Path("idSquat") int idSquat);

    @DELETE("rm/cleanjerk/{idUser}/{idCleanJerk}")
    Call<Void> deleteCleanJerk(@Path("idUser") int idUser, @Path("idCleanJerk") int idCleanJerk);

    @DELETE("rm/snatch/{idUser}/{idSnatch}")
    Call<Void> deleteSnatch(@Path("idUser") int idUser, @Path("idSnatch") int idSnatch);

}
