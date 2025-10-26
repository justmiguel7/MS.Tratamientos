package com.proyecto.tratamientos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.tratamientos.entidades.Tratamientos;


import com.proyecto.tratamientos.dto.TratamientosDTO;

public interface TratamientosService {
	public Tratamientos agregarTratamiento(TratamientosDTO tratamientoDTO ) throws Exception;

	public Tratamientos buscarPorNombre (String Nombre) throws Exception;

	public Tratamientos buscarPorNombreYDescripcion (String Nombre, String Descripcion) throws Exception;

	public List<Tratamientos> listado () throws Exception;

	public void eliminarTratamiento (int id) throws Exception;
	
	Tratamientos buscarPorId(int id) throws Exception;

	

}
