package com.example.citasmedicas.controller;

import com.example.citasmedicas.model.CitaMedica;
import com.example.citasmedicas.service.CitaMedicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CitaMedica> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public CitaMedica obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/estado/{estado}")
    public List<CitaMedica> obtenerPorEstado(@PathVariable String estado) {
        return service.obtenerPorEstado(estado);
    }

    @GetMapping("/fecha")
    public List<CitaMedica> obtenerPorFecha(@RequestParam String fecha) {
        return service.obtenerPorFecha(fecha);
    }

    @GetMapping("/disponibles")
    public List<CitaMedica> obtenerDisponiblesPorFecha(@RequestParam String fecha) {
        return service.obtenerDisponiblesPorFecha(fecha);
    }

    @PostMapping
    public CitaMedica crear(@RequestBody CitaMedica cita) {
        return service.crear(cita);
    }

    @PutMapping("/{id}")
    public CitaMedica actualizar(@PathVariable Long id, @RequestBody CitaMedica cita) {
        return service.actualizar(id, cita);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Cita eliminada correctamente";
    }
}