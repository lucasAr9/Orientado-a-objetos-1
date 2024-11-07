package ar.edu.unlp.oo1.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	
//	private int cantDeProductos;
//	private double pesoTotal;
//	private double precioTotal;
	private List<Producto> productos;
	
	public Balanza() {
//		this.cantDeProductos = 0;
//		this.pesoTotal = 0;
//		this.precioTotal = 0;
		this.productos = new ArrayList<Producto>();
	}
	
	public void ponerEnCero() {
//		this.cantDeProductos = 0;
//		this.pesoTotal = 0;
//		this.precioTotal = 0;
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto p) {
//		this.cantDeProductos += 1;
//		this.pesoTotal += p.getPeso();
//		this.precioTotal += p.getPrecioPorKilo();
		this.productos.add(p);
	}

	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public Ticket emitirTicket() {
//		Ticket t = new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
//		return t;
		Ticket t = new Ticket(this.productos);
		return t;
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
}
