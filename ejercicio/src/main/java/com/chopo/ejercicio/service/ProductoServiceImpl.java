package com.chopo.ejercicio.service;

import java.util.List;

import com.chopo.ejercicio.dao.EjercicioDao;
import com.chopo.ejercicio.dto.ProductoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import jakarta.persistence.PersistenceException;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	EjercicioDao ejercicioDao;
	
	@Override
	public String agregarProducto(ProductoDto productoDto) {
		if (ejercicioDao.save(productoDto) != null)
			return "Registro de producto exitoso.";
		else
			throw new PersistenceException();
	}

	@Override
	public String actualizaProducto(ProductoDto producto) throws Exception {
		if(ejercicioDao.findById(producto.getIdProducto()) != null) {
			if (ejercicioDao.save(producto) != null)
				return "Actualización de producto exitosa.";
			else
				throw new PersistenceException();
		}
		else {
			throw new Exception();
		}
	}

	@Override
	public List<ProductoDto> consultaProducto(ProductoDto producto) {
		Example<ProductoDto> example = Example.of(producto);
		List<ProductoDto> productoDtos = ejercicioDao.findAll(example);
		return productoDtos;
	}
}
