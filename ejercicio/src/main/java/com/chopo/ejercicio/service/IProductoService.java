package com.chopo.ejercicio.service;

import java.util.List;

import com.chopo.ejercicio.dto.ProductoDto;

public interface IProductoService {
	
	String agregarProducto(ProductoDto producto);

	String actualizaProducto(ProductoDto producto) throws Exception;

	List<ProductoDto> consultaProducto(ProductoDto producto);

}
