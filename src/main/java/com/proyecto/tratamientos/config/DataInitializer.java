package com.proyecto.tratamientos.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.tratamientos.entidades.Tratamientos;
import com.proyecto.tratamientos.repository.TratamientosRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initTratamientos(TratamientosRepository tratamientosRepository) {
        return args -> {
            if (tratamientosRepository.count() == 0) {
                System.out.println("🦷 Creando tratamientos iniciales...");

                Tratamientos limpieza = new Tratamientos();
                limpieza.setNombre("Limpieza dental");
                limpieza.setDescripcion("Limpieza profunda de dientes y encías");
                limpieza.setCostoBase(new BigDecimal("5000.00"));
                limpieza.setDuracionEstimado("30 minutos");

                Tratamientos obturacion = new Tratamientos();
                obturacion.setNombre("Obturación");
                obturacion.setDescripcion("Relleno de cavidades con material restaurador");
                obturacion.setCostoBase(new BigDecimal("8000.00"));
                obturacion.setDuracionEstimado("45 minutos");

                Tratamientos extraccion = new Tratamientos();
                extraccion.setNombre("Extracción");
                extraccion.setDescripcion("Extracción de diente permanente o temporal");
                extraccion.setCostoBase(new BigDecimal("10000.00"));
                extraccion.setDuracionEstimado("60 minutos");

                Tratamientos ortodoncia = new Tratamientos();
                ortodoncia.setNombre("Ortodoncia");
                ortodoncia.setDescripcion("Colocación de brackets y ajustes periódicos");
                ortodoncia.setCostoBase(new BigDecimal("150000.00"));
                ortodoncia.setDuracionEstimado("12 meses");

                Tratamientos blanqueamiento = new Tratamientos();
                blanqueamiento.setNombre("Blanqueamiento dental");
                blanqueamiento.setDescripcion("Tratamiento de blanqueamiento estético");
                blanqueamiento.setCostoBase(new BigDecimal("12000.00"));
                blanqueamiento.setDuracionEstimado("1 hora");

                Tratamientos endodoncia = new Tratamientos();
                endodoncia.setNombre("Endodoncia");
                endodoncia.setDescripcion("Tratamiento de conducto para salvar el diente");
                endodoncia.setCostoBase(new BigDecimal("20000.00"));
                endodoncia.setDuracionEstimado("90 minutos");

                Tratamientos profilaxis = new Tratamientos();
                profilaxis.setNombre("Profilaxis infantil");
                profilaxis.setDescripcion("Limpieza y prevención para niños");
                profilaxis.setCostoBase(new BigDecimal("4000.00"));
                profilaxis.setDuracionEstimado("30 minutos");

                Tratamientos sellantes = new Tratamientos();
                sellantes.setNombre("Sellantes dentales");
                sellantes.setDescripcion("Protección de superficies de masticación en molares");
                sellantes.setCostoBase(new BigDecimal("3500.00"));
                sellantes.setDuracionEstimado("20 minutos");

                Tratamientos implante = new Tratamientos();
                implante.setNombre("Implante dental");
                implante.setDescripcion("Colocación de implante y corona");
                implante.setCostoBase(new BigDecimal("80000.00"));
                implante.setDuracionEstimado("3 meses");

                Tratamientos rehabilitacion = new Tratamientos();
                rehabilitacion.setNombre("Rehabilitación estética");
                rehabilitacion.setDescripcion("Carillas o coronas estéticas");
                rehabilitacion.setCostoBase(new BigDecimal("50000.00"));
                rehabilitacion.setDuracionEstimado("2 semanas");

                // Guardar todos los tratamientos
                tratamientosRepository.save(limpieza);
                tratamientosRepository.save(obturacion);
                tratamientosRepository.save(extraccion);
                tratamientosRepository.save(ortodoncia);
                tratamientosRepository.save(blanqueamiento);
                tratamientosRepository.save(endodoncia);
                tratamientosRepository.save(profilaxis);
                tratamientosRepository.save(sellantes);
                tratamientosRepository.save(implante);
                tratamientosRepository.save(rehabilitacion);

                System.out.println("Tratamientos creados exitosamente ✅");
            }
        };
    }
}