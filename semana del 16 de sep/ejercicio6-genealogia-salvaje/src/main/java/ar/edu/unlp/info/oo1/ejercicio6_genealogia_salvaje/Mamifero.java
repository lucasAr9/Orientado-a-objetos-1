package ar.edu.unlp.info.oo1.ejercicio6_genealogia_salvaje;

import java.time.LocalDate;

public class Mamifero {

	private String nombre;
	private String id;
	private String especie;
	private LocalDate fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

	public Mamifero() {
		
	}
	
	public Mamifero(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getIdentificador() {
		return id;
	}

	public void setIdentificador(String id) {
		this.id = id;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate f) {
		this.fechaNacimiento = f;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
//	Abuelo de parte de la madre
	public Mamifero getAbueloMaterno() {
		return madre != null ? madre.getPadre() : null;
	}
	
//	Abuela de parte de la madre
	public Mamifero getAbuelaMaterna() {
		return madre != null ? madre.getMadre() : null;
	}
	
//	Abuelo de parte del padre
	public Mamifero getAbueloPaterno() {
		return padre != null ? padre.getPadre() : null;
	}
	
//  Abuela de parte del padre
	public Mamifero getAbuelaPaterna() {
		return padre != null ? padre.getMadre() : null;
	}
	
	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		return this.tieneComoAncestroMaterno(unMamifero) || this.tieneComoAncestroPaterno(unMamifero);
	}

	public Boolean tieneComoAncestroMaterno(Mamifero unMamifero) {
		if (this.getMadre() != null) {
			return this.getMadre().equals(unMamifero) || this.getMadre().tieneComoAncestroA(unMamifero);
		}
		return false;
	}
	public Boolean tieneComoAncestroPaterno(Mamifero unMamifero) {
		if (this.getPadre() != null) {
			return this.getPadre().equals(unMamifero) || this.getPadre().tieneComoAncestroA(unMamifero);
		}
		return false;
	}
}
