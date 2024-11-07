package ar.edu.unlp.info.oo1.ejercicio4_figuras_y_cuerpos;

public class Cuadrado extends Figura{
	private double lado;
	
	public Cuadrado() {
		
	}
	
	public double getLado() {
		return lado;
	}
	
	public void setLado(double l) {
		lado = l;
	}

	public double getPerimetro() {
		return lado * 4;
	}
	
	public double getArea() {
		return Math.pow(lado, 2);
	}
}
