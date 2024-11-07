package ar.edu.unlp.oo1.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private LocalDate fecha;
//	private int cantDeProductos;
//	private double pesoTotal;
//	private double precioTotal;
	private List<Producto> productos;
	
	public Ticket(List<Producto> p) {
//	public Ticket(int cantDeProductos, double pesoTotal, double precioTotal) {
//		this.cantDeProductos = cantDeProductos;
//		this.pesoTotal = pesoTotal;
//		this.precioTotal = precioTotal;
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<Producto>();
		this.productos = p;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
//		return cantDeProductos;
		return this.productos.size();
	}

	public double getPesoTotal() {
//		return pesoTotal;
		return this.productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}

	public double getPrecioTotal() {
//		return precioTotal;
		return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}

	public double impuesto() {
//		return this.precioTotal * 21 / 100;
		return getPrecioTotal() * 21 / 100;
	}
	
	@Override
	public String toString() {
		return "Ticket [getFecha()=" + this.getFecha() + ", getCantDeProductos()=" + this.getCantidadDeProductos()
				+ ", getPesoTotal()=" + this.getPesoTotal() + ", getPrecioTotal()=" + this.getPrecioTotal() + "]";
	}
}
