package com.chopo.ejercicio.dao;

import com.chopo.ejercicio.dto.ProductoDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioDao extends JpaRepository<ProductoDto, String>{
}
