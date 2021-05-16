package com.crudCYES.model;

import java.sql.Date;

public class Suscriptor {
	private int idSuscriptor;
	private String nomPila;
	private String apPat;
	private String apMat;
	private String servicio;
	private Date fechaNac;
	private String estatus;
	private String plan;
	
	public Suscriptor(int idSuscriptor, String nomPila, String apPat, String apMat, String servicio, Date fechaNac,
			String estatus, String plan) {
		super();
		this.idSuscriptor = idSuscriptor;
		this.nomPila = nomPila;
		this.apPat = apPat;
		this.apMat = apMat;
		this.servicio = servicio;
		this.fechaNac = fechaNac;
		this.estatus = estatus;
		this.plan = plan;
		
		
	      }
	
      public Suscriptor() {
	    // TODO Auto-generated constructor stub
      }
      
	public int getIdSuscriptor() {
		return idSuscriptor;
	}
	public void setIdSuscriptor(int idSuscriptor) {
		this.idSuscriptor = idSuscriptor;
	}
	public String getNomPila() {
		return nomPila;
	}
	public void setNomPila(String nomPila) {
		this.nomPila = nomPila;
	}
	public String getApPat() {
		return apPat;
	}
	public void setApPat(String apPat) {
		this.apPat = apPat;
	}
	public String getApMat() {
		return apMat;
	}
	public void setApMat(String apMat) {
		this.apMat = apMat;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Suscriptor [idSuscriptor=" + idSuscriptor + ", nomPila=" + nomPila + ", apPat=" + apPat + ", apMat="
				+ apMat + ", servicio=" + servicio + ", fechaNac=" + fechaNac + ", estatus=" + estatus + ", plan="
				+ plan + "]";
	}

}
