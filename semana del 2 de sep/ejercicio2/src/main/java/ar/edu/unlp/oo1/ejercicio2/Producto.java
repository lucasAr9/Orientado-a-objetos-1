package ar.edu.unlp.oo1.ejercicio2;

public class Producto {
	
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto() {
		this.peso = 0;
		this.precioPorKilo = 0;
		this.descripcion = "nn";
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precioPorKilo;
	}
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
