package ar.edu.unlp.info.oo1.ejercicio7_red_de_alumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {

	private List<Farola> farolas;
	private boolean encendida;

	public Farola() {
		this.farolas = new ArrayList<Farola>();
		this.encendida = false;
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	* entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	* de otraFarola, al igual que otraFarola también se convertirá en vecina del
	* receptor del mensaje.
	*/
	public void pairWithNeighbor(Farola otraFarola) {
		this.farolas.add(otraFarola);
		otraFarola.pairWithNeighborMutuo(this);
	}
	public void pairWithNeighborMutuo(Farola otraFarola) {
		this.farolas.add(otraFarola);
	}

	/*
	* Retorna sus farolas vecinas.
	*/
	public List<Farola> getNeighbors() {
		return farolas;
	}
	
	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!encendida) {
			this.encendida = true;
			this.propagarTurnOn();
		}
	}
	private void propagarTurnOn() {
		for (Farola f : farolas) {
			f.turnOn();
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (encendida) {
			this.encendida = false;
			this.propagarTurnOff();
		}
	}
	public void propagarTurnOff() {
		for (Farola f : farolas) {
			f.turnOff();
		}
	}
	
	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.encendida;
	}
	
	/*
	* Retorna true si la farola está apagada.
	*/
	public boolean isOff() {
		return !encendida;
	}
}
