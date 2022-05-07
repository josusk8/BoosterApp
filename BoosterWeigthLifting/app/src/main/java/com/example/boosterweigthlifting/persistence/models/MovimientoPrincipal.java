package com.example.boosterweigthlifting.persistence.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovimientoPrincipal implements Serializable {

	@SerializedName("idMovimientoprincipal")
	@Expose
	private int idMovimientoprincipal;

	@SerializedName("idWod")
	@Expose
	private int idWod;

	@SerializedName("idUsuario")
	@Expose
	private int idUsuario;

	@SerializedName("nombre")
	@Expose
	private String nombre;

	@SerializedName("pesoMax")
	@Expose
	private float pesoMax;

	@SerializedName("pesoMin")
	@Expose
	private float pesoMin;

	@SerializedName("pocentajeMin")
	@Expose
	private int pocentajeMin;

	@SerializedName("porcentajeMax")
	@Expose
	private int porcentajeMax;

	@SerializedName("repsOptima")
	@Expose
	private int repsOptima;

	@SerializedName("serieMax")
	@Expose
	private int serieMax;

	@SerializedName("serieMin")
	@Expose
	private int serieMin;

	@SerializedName("repsTotalMax")
	@Expose
	private int repsTotalMax;

	@SerializedName("repsTotalMin")
	@Expose
	private int repsTotalMin;

	@SerializedName("rm")
	@Expose
	private float rm;


	public MovimientoPrincipal() {
	}

	public int getIdMovimientoprincipal() {
		return idMovimientoprincipal;
	}

	public void setIdMovimientoprincipal(int idMovimientoprincipal) {
		this.idMovimientoprincipal = idMovimientoprincipal;
	}

	public int getIdWod() {
		return idWod;
	}

	public void setIdWod(int idWod) {
		this.idWod = idWod;
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

	public float getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(float pesoMax) {
		this.pesoMax = pesoMax;
	}

	public float getPesoMin() {
		return pesoMin;
	}

	public void setPesoMin(float pesoMin) {
		this.pesoMin = pesoMin;
	}

	public int getPocentajeMin() {
		return pocentajeMin;
	}

	public void setPocentajeMin(int pocentajeMin) {
		this.pocentajeMin = pocentajeMin;
	}

	public int getPorcentajeMax() {
		return porcentajeMax;
	}

	public void setPorcentajeMax(int porcentajeMax) {
		this.porcentajeMax = porcentajeMax;
	}

	public int getRepsOptima() {
		return repsOptima;
	}

	public void setRepsOptima(int repsOptima) {
		this.repsOptima = repsOptima;
	}

	public int getSerieMax() {
		return serieMax;
	}

	public void setSerieMax(int serieMax) {
		this.serieMax = serieMax;
	}

	public int getSerieMin() {
		return serieMin;
	}

	public void setSerieMin(int serieMin) {
		this.serieMin = serieMin;
	}

	public int getRepsTotalMax() {
		return repsTotalMax;
	}

	public void setRepsTotalMax(int repsTotalMax) {
		this.repsTotalMax = repsTotalMax;
	}

	public int getRepsTotalMin() {
		return repsTotalMin;
	}

	public void setRepsTotalMin(int repsTotalMin) {
		this.repsTotalMin = repsTotalMin;
	}

	public float getRm() {
		return rm;
	}

	public void setRm(float rm) {
		this.rm = rm;
	}
}