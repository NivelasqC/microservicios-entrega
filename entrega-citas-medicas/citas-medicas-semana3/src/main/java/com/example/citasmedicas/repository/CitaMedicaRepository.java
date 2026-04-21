package com.example.citasmedicas.repository;

import com.example.citasmedicas.model.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
    List<CitaMedica> findByEstado(String estado);
    List<CitaMedica> findByFecha(LocalDate fecha);
    List<CitaMedica> findByFechaAndEstado(LocalDate fecha, String estado);
}
