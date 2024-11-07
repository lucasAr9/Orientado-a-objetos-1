package ar.edu.unlp.info.oo1.ejercicio4_figuras_y_cuerpos;

public class Circulo extends Figura {
	private double pi = Math.PI;
	private double radio;
	private double diametro;

	public Circulo() {
		
	}
	
	public double getDiametro() {
		return diametro;
	}
	
	public void setDiametro(double d) {
		this.diametro = d;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double r) {
		this.radio = r;
		this.diametro = radio * 2;
	}
	
	public double getPerimetro() {
		return pi * this.getDiametro();
	}
	
	public double getArea() {
		return pi * Math.pow(this.getRadio(), 2);
	}
}
