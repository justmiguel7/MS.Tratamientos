package com.proyecto.tratamientos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.tratamientos.entidades.Tratamientos;


public interface TratamientosRepository extends JpaRepository<Tratamientos, Integer>{

	public Optional<Tratamientos> findByNombre (String Nombre) throws Exception; 
	
	public Optional<Tratamientos> findByNombreAndDescripcion (String Nombre, String Descripcion) throws Exception; 

	
}
