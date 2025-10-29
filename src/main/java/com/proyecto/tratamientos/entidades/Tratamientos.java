package com.proyecto.tratamientos.entidades;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Tratamientos {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "CostoBase")
    private BigDecimal costoBase;

    @Column(name = "DuracionEstimado")
    private String duracionEstimado;
    
   


	


	public Tratamientos(int id, String nombre, String descripcion, BigDecimal costoBase, String duracionEstimado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoBase = costoBase;
		this.duracionEstimado = duracionEstimado;

	}
	
   public Tratamientos() {
	   
   }


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public BigDecimal getCostoBase() {
		return costoBase;
	}



	public void setCostoBase(BigDecimal costoBase) {
		this.costoBase = costoBase;
	}



	public String getDuracionEstimado() {
		return duracionEstimado;
	}



	public void setDuracionEstimado( String duracionEstimado) {
		this.duracionEstimado = duracionEstimado;
	}






}