package com.proyecto.tratamientos.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.tratamientos.entidades.Tratamientos;
import com.proyecto.tratamientos.dto.TratamientosDTO;

import com.proyecto.tratamientos.service.TratamientosService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "false")
@RequestMapping("/tratamiento")
public class TratamientosController {

	
	
	@Autowired
	private TratamientosService tratamientosService;
		

  @RequestMapping(value="/agregar", method={RequestMethod.POST})
	public ResponseEntity<TratamientosDTO> persistirTratamiento (@Valid @RequestBody  TratamientosDTO tratamientoDTO ) throws Exception{
		
	  tratamientosService.agregarTratamiento(tratamientoDTO);

		return new ResponseEntity<TratamientosDTO>(tratamientoDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/buscar/{nombre}", method={RequestMethod.GET})
	public ResponseEntity<Tratamientos> busarPorNombre ( @PathVariable("nombre") String nombre) throws Exception{
		Tratamientos tratamientos = tratamientosService.buscarPorNombre(nombre);
		  return new ResponseEntity<>(tratamientos,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/buscarPorapellido/{nombre}/{apellido}", method={RequestMethod.GET})
	public ResponseEntity<Tratamientos> buscarPorApellido ( @PathVariable("nombre") String Nombre, @PathVariable("descripcion") String Descripcion) throws Exception{
		Tratamientos tratamientos = tratamientosService.buscarPorNombreYDescripcion(Nombre, Descripcion);
		  return new ResponseEntity<>(tratamientos,HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/listado", method={RequestMethod.GET})
	public ResponseEntity<List<Tratamientos>> listado() throws Exception{
		  return new ResponseEntity<>(tratamientosService.listado(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/eliminar/{id}", method={RequestMethod.GET})
	public ResponseEntity<Tratamientos> eliminarPaciente(@PathVariable("id") int id) throws Exception{
		tratamientosService.eliminarTratamiento(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}

