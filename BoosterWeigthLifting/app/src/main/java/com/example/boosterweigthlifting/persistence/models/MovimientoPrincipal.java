package com.example.boosterweigthlifting.persistence.models;

import java.io.Serializable;

public class MovimientoPrincipal implements Serializable {

	private int idMovimientoprincipal;

	private int idWod;
	
	private int idUsuario;

	private String nombre;

	private float pesoMax;

	private float pesoMin;

	private int pocentajeMin;

	private int porcentajeMax;

	private int repsOptima;

	private int serieMax;

	private int serieMin;

	private int repsTotalMax;

	private int repsTotalMin;

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