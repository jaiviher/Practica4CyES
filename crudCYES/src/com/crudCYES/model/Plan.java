package com.crudCYES.model;

public class Plan {
	private int idPlan;
	private String nombre;
	private String importe;
	
	public Plan(int idPlan, String nombre, String importe) {
		super();
		this.idPlan = idPlan;
		this.nombre = nombre;
		this.importe = importe;
	}
	
	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Plan [idPlan=" + idPlan + ", nombre=" + nombre + ", importe=" + importe + "]";
	}

	
}
