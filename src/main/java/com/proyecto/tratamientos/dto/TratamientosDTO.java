package com.proyecto.tratamientos.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.math.BigDecimal;


import com.proyecto.tratamientos.entidades.Tratamientos;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TratamientosDTO {

    private int id;

    @NotEmpty
    @Size(min = 4, max = 15, message = "La longitud del nombre es entre 4 y 15 caracteres")
    private String nombre;

    @NotEmpty
    @Size(min = 4, max = 25, message = "La longitud de la descripción es entre 4 y 25 caracteres")
    private String descripcion;

   @NotNull
  @Positive
    private BigDecimal costoBase;

    @NotEmpty
    @Size(min = 4, max = 30, message = "La longitud de la duración es entre 4 y 30 caracteres")
    private String duracionEstimado;

    @NotNull
    private LocalDateTime fechaCreacion;

  


    // 🔹 Constructor con parámetros
    public TratamientosDTO(String nombre, String descripcion, BigDecimal costoBase,
                           	String duracionEstimado, LocalDateTime fechaCreacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.duracionEstimado = duracionEstimado;
        this.fechaCreacion = fechaCreacion;
       
    }

    // 🔹 Convierte el DTO a Entidad
    public Tratamientos toEntity( String codigo ){
		return new Tratamientos(this.nombre,this.descripcion,this.costoBase,this.duracionEstimado,this.fechaCreacion);
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



	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



    
    
    
    
}
