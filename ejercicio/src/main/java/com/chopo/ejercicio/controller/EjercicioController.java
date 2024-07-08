package com.chopo.ejercicio.controller;

import java.util.List;

import com.chopo.ejercicio.dto.ProductoDto;
import com.chopo.ejercicio.service.IProductoService;
import com.chopo.ejercicio.util.EjercicioConstantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Clase de tipo controlador para manejo de end points.
 */
@RestController
@RequestMapping(EjercicioConstantes.BASE_PATH)
public class EjercicioController {
	
	@Autowired
	IProductoService productoService;
	
	/**
	 * Método para agregar un nuevo producto.
	 * @param producto
	 * @return
	 */
	@PostMapping(EjercicioConstantes.PATH_AGREGAR)
	public String agregarProducto(@RequestBody ProductoDto producto) {
		return productoService.agregarProducto(producto);
	}
	
	@PutMapping(EjercicioConstantes.PATH_ACTUALIZAR)
	public String actualizaProducto(@RequestBody ProductoDto producto) throws Exception {
		return productoService.actualizaProducto(producto);
	}
	
	@GetMapping(EjercicioConstantes.PATH_CONSULTAR)
	public List<ProductoDto> consultarProducto(@RequestBody ProductoDto producto) {
		return productoService.consultaProducto(producto);
	}
}
