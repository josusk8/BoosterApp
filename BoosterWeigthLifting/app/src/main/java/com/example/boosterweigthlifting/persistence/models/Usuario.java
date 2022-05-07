package com.example.boosterweigthlifting.persistence.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("idUsuario")
    @Expose
    private int idUsuario;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("pass")
    @Expose
    private String pass;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("apellidos")
    @Expose
    private String apellidos;

    @SerializedName("sexo")
    @Expose
    private String sexo;

    @SerializedName("fechaNacimiento")
    @Expose
    private String fechaNacimiento;

    @SerializedName("peso")
    @Expose
    private float peso;

    public Usuario(){
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
