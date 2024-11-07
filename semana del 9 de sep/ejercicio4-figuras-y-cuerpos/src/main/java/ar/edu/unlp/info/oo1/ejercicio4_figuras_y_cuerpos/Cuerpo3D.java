package ar.edu.unlp.info.oo1.ejercicio4_figuras_y_cuerpos;

public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;
	
	public Cuerpo3D() {
		
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setAltura(double a) {
		this.altura = a;
	}
	
	public double getCaraBasal() {
		return caraBasal.getArea();
	}
	
	public void setCaraBasal(Figura cb) {
		this.caraBasal = cb;
	}
	
	public double getVolumen() {
//		área-cara-basal * altura
		return this.getCaraBasal() * this.getAltura();
	}
		
	public double getSuperficieExterior() {
//		2* área-cara-basal + perímetro-cara-basal * altura-del-cuerpo
		return 2 * this.getCaraBasal() + this.caraBasal.getPerimetro() * this.getAltura();
	}
}
