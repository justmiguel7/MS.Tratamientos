package com.proyecto.tratamientos.dto;

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

    // Constructor con parámetros
    public TratamientosDTO(String nombre, String descripcion, BigDecimal costoBase, String duracionEstimado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.duracionEstimado = duracionEstimado;
    }

    public Tratamientos toEntity() {
        return new Tratamientos(this.id, this.nombre, this.descripcion, this.costoBase, this.duracionEstimado);
    }

    public TratamientosDTO() {}
    
    public BigDecimal getCosto() {
        return this.costoBase;
    }

}
