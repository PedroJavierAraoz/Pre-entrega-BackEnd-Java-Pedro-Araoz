package com.tech.productos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

	private final String numero;
	private final String cliente;
	private final LocalDateTime fechaCreacion;
	private final List<Producto> productos;

	public Pedido(String numero, String cliente) {
		this(numero, cliente, LocalDateTime.now(), new ArrayList<>());
	}

	public Pedido(String numero, String cliente, List<Producto> productos) {
		this(numero, cliente, LocalDateTime.now(), productos);
	}

	private Pedido(String numero, String cliente, LocalDateTime fechaCreacion, List<Producto> productos) {
		if (numero == null || numero.isBlank()) {
			throw new IllegalArgumentException("El numero del pedido es obligatorio");
		}
		if (cliente == null || cliente.isBlank()) {
			throw new IllegalArgumentException("El nombre del cliente es obligatorio");
		}
		if (productos == null) {
			throw new IllegalArgumentException("La lista de productos no puede ser null");
		}

		this.numero = numero;
		this.cliente = cliente;
		this.fechaCreacion = fechaCreacion;
		this.productos = new ArrayList<>(productos);
	}

	public String getNumero() {
		return numero;
	}

	public String getCliente() {
		return cliente;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public List<Producto> getProductos() {
		return Collections.unmodifiableList(productos);
	}

	public void agregarProducto(Producto producto) {
		if (producto == null) {
			throw new IllegalArgumentException("El producto no puede ser null");
		}
		productos.add(producto);
	}

	public boolean eliminarProducto(Producto producto) {
		return productos.remove(producto);
	}

	public double getTotal() {
		return productos.stream().mapToDouble(Producto::getPrecio).sum();
	}

}
