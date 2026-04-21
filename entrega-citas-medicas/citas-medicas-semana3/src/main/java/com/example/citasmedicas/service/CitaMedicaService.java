package com.example.citasmedicas.service;

import com.example.citasmedicas.model.CitaMedica;
import com.example.citasmedicas.repository.CitaMedicaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaMedicaService {

    private final CitaMedicaRepository repository;

    public CitaMedicaService(CitaMedicaRepository repository) {
        this.repository = repository;
    }

    public List<CitaMedica> obtenerTodas() {
        return repository.findAll();
    }

    public CitaMedica obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));
    }

    public List<CitaMedica> obtenerPorEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public List<CitaMedica> obtenerPorFecha(String fecha) {
        return repository.findByFecha(LocalDate.parse(fecha));
    }

    public List<CitaMedica> obtenerDisponiblesPorFecha(String fecha) {
        return repository.findByFechaAndEstado(LocalDate.parse(fecha), "DISPONIBLE");
    }

    public CitaMedica crear(CitaMedica cita) {
        return repository.save(cita);
    }

    public CitaMedica actualizar(Long id, CitaMedica citaActualizada) {
        CitaMedica citaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + id));

        citaExistente.setNombrePaciente(citaActualizada.getNombrePaciente());
        citaExistente.setNombreMedico(citaActualizada.getNombreMedico());
        citaExistente.setEspecialidad(citaActualizada.getEspecialidad());
        citaExistente.setFecha(citaActualizada.getFecha());
        citaExistente.setHora(citaActualizada.getHora());
        citaExistente.setEstado(citaActualizada.getEstado());
        citaExistente.setObservacion(citaActualizada.getObservacion());

        return repository.save(citaExistente);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }
}