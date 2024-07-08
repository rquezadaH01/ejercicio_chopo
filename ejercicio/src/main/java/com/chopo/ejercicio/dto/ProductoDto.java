package com.chopo.ejercicio.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "productos")
public class ProductoDto implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_PRODUCTO")
	String idProducto;
	
	@Column(name = "NOMBRE")
	String nombre;

	@Column(name = "MARCA")
	String marca;
	
	@Column(name = "CATEGORIA")
	String categoria;
	
	@Column(name = "PRECIO")
	Float precio;
	
	public ProductoDto() {
		super();
	}

	public ProductoDto(String idProducto, String nombre, String marca, String categoria, Float precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
}
