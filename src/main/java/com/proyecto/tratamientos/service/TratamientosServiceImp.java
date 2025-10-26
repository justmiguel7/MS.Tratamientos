package com.proyecto.tratamientos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  // <-- IMPORTANTE

import com.proyecto.tratamientos.entidades.Tratamientos;
import com.proyecto.tratamientos.repository.TratamientosRepository;

import com.proyecto.tratamientos.dto.TratamientosDTO;

@Service   
public class TratamientosServiceImp implements TratamientosService {

    @Autowired
    private TratamientosRepository   tratamientosRepository;


    @Override
    public Tratamientos agregarTratamiento(TratamientosDTO tratamientoDTO) throws Exception {
        String codigo = UUID.randomUUID().toString();
        return tratamientosRepository.save(tratamientoDTO.toEntity());
   
	}


	@Override
	public Tratamientos buscarPorNombre(String nombre) throws Exception {
		Optional<Tratamientos> optTratamientos = tratamientosRepository.findByNombre(nombre);
        return optTratamientos.orElseThrow(() -> new Exception("Tratamiento no encontrado con nombre: " + nombre));
	}


	@Override
	public Tratamientos buscarPorNombreYDescripcion(String nombre, String Descripcion) throws Exception {
		 Optional<Tratamientos> optTratamientos = tratamientosRepository.findByNombreAndDescripcion(nombre, Descripcion);
	        return optTratamientos.orElseThrow(() -> new Exception("Tratamiento no encontrado con nombre y Descripcion: " + nombre + " " + Descripcion));
	}


	@Override
	public List<Tratamientos> listado() throws Exception {
		// TODO Auto-generated method stub
		 return tratamientosRepository.findAll();
    }
	


	@Override
	public void eliminarTratamiento(int id) throws Exception {
		 Optional<Tratamientos> optTratamientos = tratamientosRepository.findById(id);
		 Tratamientos tratamiento = optTratamientos.orElseThrow(() -> new Exception("Tratamiento no encontrado con id: " + id));
		 tratamientosRepository.delete(tratamiento);
		
	}
	
	@Override
	public Tratamientos buscarPorId(int id) throws Exception {
	    Optional<Tratamientos> optTratamiento = tratamientosRepository.findById(id);
	    return optTratamiento.orElseThrow(() -> new Exception("Tratamiento no encontrado con id: " + id));
	}

}
