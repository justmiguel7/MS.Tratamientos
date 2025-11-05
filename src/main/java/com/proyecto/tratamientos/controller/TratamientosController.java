package com.proyecto.tratamientos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.tratamientos.entidades.Tratamientos;
import com.proyecto.tratamientos.dto.TratamientosDTO;
import com.proyecto.tratamientos.service.TratamientosService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Ajustá según tu frontend
@RequestMapping("/tratamientos")
public class TratamientosController {

    @Autowired
    private TratamientosService tratamientosService;

    @PostMapping("/agregar")
    public ResponseEntity<Tratamientos> persistirTratamiento(
            @Valid @RequestBody TratamientosDTO tratamientoDTO) throws Exception {

        Tratamientos nuevo = tratamientosService.agregarTratamiento(tratamientoDTO);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Tratamientos> buscarPorNombre(@PathVariable String nombre) throws Exception {
        Tratamientos tratamiento = tratamientosService.buscarPorNombre(nombre);
        return new ResponseEntity<>(tratamiento, HttpStatus.OK);
    }

    @GetMapping("/buscarPorNombreDescripcion/{nombre}/{descripcion}")
    public ResponseEntity<Tratamientos> buscarPorNombreYDescripcion(
            @PathVariable String nombre,
            @PathVariable String descripcion) throws Exception {

        Tratamientos tratamiento = tratamientosService.buscarPorNombreYDescripcion(nombre, descripcion);
        return new ResponseEntity<>(tratamiento, HttpStatus.OK);
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Tratamientos>> listado() throws Exception {
        List<Tratamientos> lista = tratamientosService.listado();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable int id) throws Exception {
        tratamientosService.eliminarTratamiento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tratamientos> buscarPorId(@PathVariable int id) throws Exception {
        Tratamientos tratamiento = tratamientosService.buscarPorId(id);
        return new ResponseEntity<>(tratamiento, HttpStatus.OK);
    }
    
    @PostMapping("/por-ids")
    public ResponseEntity<List<Tratamientos>> buscarPorIds(@RequestBody List<Integer> ids) throws Exception {
        List<Tratamientos> tratamientos = tratamientosService.buscarPorIds(ids);
        return new ResponseEntity<>(tratamientos, HttpStatus.OK);
    }


}
